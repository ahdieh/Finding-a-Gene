
/**
 * Finding a Gene
 * 
 * @author Ahdieh
 * @version Aug 02, 2018
 */
public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna) {
        String result = "";
        //start codon is "ATG"
        //stop codon is "TAA"
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        result = dna.substring(startIndex, stopIndex + 3);
        return result;
    }

    public void testFindGeneSimple(){
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
    }
}
