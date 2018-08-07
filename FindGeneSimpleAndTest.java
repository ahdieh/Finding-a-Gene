
/**
 * Finding a Gene
 * 
 * @author Ahdieh
 * @version Aug 02, 2018
 */
public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna) {
        String gene = "";
        //start codon is "ATG"
        //stop codon is "TAA"
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) gene = ""; // no "ATG"
        else {  
            int stopIndex = dna.indexOf("TAA", startIndex + 3);
            if (stopIndex == -1) gene = "";  // no "TAA"   
            while ((stopIndex - startIndex) % 3 != 0 && stopIndex != -1) {
            stopIndex =  dna.indexOf("TAA", stopIndex + 3);
            if (stopIndex == -1) gene = "";  // no "TAA"             
        }
        if (stopIndex != -1 && (stopIndex - startIndex) % 3 == 0) gene = dna.substring(startIndex, stopIndex + 3);
    }
    return gene; 
    }

    public void testFindGeneSimple(){
        System.out.println();
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        // no "ATG"
        dna = "TGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        // no "TAA"
        dna = "ATGTA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AATGCGTAATTAATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
    }
}
