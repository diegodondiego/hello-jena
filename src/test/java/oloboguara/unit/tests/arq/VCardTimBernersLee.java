/**
 * Oi. Copie livremente, mas cite a fonte!
 * @CC 2014
 * 
 */
package oloboguara.unit.tests.arq;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.DatasetFactory;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;

/**
 * Acessando o {@link Dataset} do Tim Berners-Lee.
 * 
 * @author dinhego
 * 
 */
public class VCardTimBernersLee {

	private static Dataset datasetTBL;

	/**
	 * 
	 */
	@BeforeClass
	public static void buscaDataSet() {
		datasetTBL = DatasetFactory.create("http://www.w3.org/People/Berners-Lee/card");

		assertTrue(datasetTBL != null);
	}

	/**
	 * 
	 */
	@Test
	public void imprimeVCardDoTBL() {

		String querySimples = "PREFIX foaf:  <http://xmlns.com/foaf/0.1/> SELECT * WHERE { ?person foaf:name ?name . ?person foaf:mbox ?email . }";

		Query busca = QueryFactory.create(querySimples);

		assertTrue(busca != null);

		ResultSet resultado = QueryExecutionFactory.create(busca, datasetTBL).execSelect();
		ResultSetFormatter.outputAsJSON(resultado);

		assertTrue(resultado != null);

		while (resultado.hasNext()) {
			QuerySolution solucao = resultado.next();

			solucao.toString();
		}

	}
}
