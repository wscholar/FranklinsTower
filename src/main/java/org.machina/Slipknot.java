package org.machina;

import java.util.Collection;

import org.canova.api.util.ClassPathResource;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wscholar on 1/21/16.
 */
public class Slipknot {

	private static Logger log = LoggerFactory.getLogger(Slipknot.class);

	public void postConstruct() throws Exception {

		String filePath = new ClassPathResource("raw_sentences.txt").getFile().getAbsolutePath();

		log.info("Load & Vectorize Sentences....");
		// Strip white space before and after for each line
		SentenceIterator iter = new BasicLineIterator(filePath);
		// Split on white spaces in the line to get words
		TokenizerFactory t = new DefaultTokenizerFactory();
		t.setTokenPreProcessor(new CommonPreprocessor());

		log.info("Building model....");
		Word2Vec vec = new Word2Vec.Builder()
				.minWordFrequency(5)
				.iterations(1)
				.layerSize(100)
				.seed(42)
				.windowSize(5)
				.iterate(iter)
				.tokenizerFactory(t)
				.build();

		log.info("Fitting Word2Vec model....");
		vec.fit();

		log.info("Writing word vectors to text file....");

		// Write word vectors
		WordVectorSerializer.writeWordVectors(vec, "pathToWriteto.txt");

		log.info("Closest Words:");
		Collection<String> lst = vec.wordsNearest("day", 10);
		System.out.println(lst);
//		UiServer server = UiServer.getInstance();
//		System.out.println("Started on port " + server.getPort());
	}
}
