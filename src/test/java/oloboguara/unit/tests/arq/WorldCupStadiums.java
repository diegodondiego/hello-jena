/**
 * Oi. Copie livremente, mas cite a fonte!
 * @CC 2014
 * 
 */
package oloboguara.unit.tests.arq;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.DatasetFactory;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;

/**
 * Busca os
 * 
 * @author dinhego
 * 
 */
public class WorldCupStadiums {

	private final String sql = "select distinct * where { ?suj ?pred <http://dbpedia.org/resource/2014_FIFA_World_Cup> } LIMIT 100";

	/**
	 * 
	 */
	@Test
	public void bleh() {

		Dataset dataset = DatasetFactory.create("http://dbpedia.org/sparql");

		assertTrue(dataset != null);

		Query q = QueryFactory.create(sql);

		assertTrue(q != null);

		QueryExecution execucao = QueryExecutionFactory.create(q, dataset);

		assertTrue(execucao != null);

		execucao.execSelect();

	}
}
