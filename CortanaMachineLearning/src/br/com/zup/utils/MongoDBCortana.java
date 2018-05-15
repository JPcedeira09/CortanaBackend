package br.com.zup.utils;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.zup.cortana.models.codec.DataSetCodec;
import br.com.zup.models.cortana.entities.DataSet;

/**
 * 
 * @author joaopaulotieles
 *
 */
public class MongoDBCortana {


	private MongoClient cliente;

	/**
	 * 
	 * @param nomeCollection
	 * @return MongoCollection<Document>
	 */
	public MongoCollection<Document> getConnectionCortana(String nomeCollection) {
		
		Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		DataSetCodec dataSetCodec = new DataSetCodec(codec);
		
	    CodecRegistry registro = CodecRegistries.fromRegistries(
	            MongoClient.getDefaultCodecRegistry(), 
	            CodecRegistries.fromCodecs(dataSetCodec));
	    
	    MongoClientOptions options = MongoClientOptions.builder().codecRegistry(registro).build();

	    
	    cliente = new MongoClient("localhost", options);
		MongoDatabase database =  cliente.getDatabase("cortana");
		MongoCollection<Document> collection = database.getCollection(nomeCollection);
		
		return collection;
	}
	
	/**
	 * 
	 * @param nomeCollection
	 * @return MongoCollection<Document>
	 */
	public MongoCollection<DataSet> getConnectionCortanaDataset(String nomeCollection) {
		
		Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		DataSetCodec dataSetCodec = new DataSetCodec(codec);
		
	    CodecRegistry registro = CodecRegistries.fromRegistries(
	            MongoClient.getDefaultCodecRegistry(), 
	            CodecRegistries.fromCodecs(dataSetCodec));
	    
	    MongoClientOptions options = MongoClientOptions.builder().codecRegistry(registro).build();

	    
	    cliente = new MongoClient("localhost:27017", options);
		MongoDatabase database =  cliente.getDatabase("cortana");
		MongoCollection<DataSet> collection = database.getCollection(nomeCollection, DataSet.class);
		
		return collection;
	}
	
}
