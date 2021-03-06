
/**
 * Finding a Gene
 * 
 * @author Ahdieh
 * @version Aug 02, 2018
 */
import edu.duke.*;

public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna) {
        String gene = "";
        String dnaOrig = dna;
        //start codon is "ATG"
        //stop codon is "TAA"
        for (int i = 0; i < dna.length(); i++){
            if (Character.isLowerCase(dna.charAt(0))) {                
                dna = dna.toUpperCase();
            }
        }        
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) gene = ""; // no "ATG"
        else {  
            int stopIndex = dna.indexOf("TAA", startIndex + 3);
            if (stopIndex == -1) gene = "";  // no "TAA"   
            while ((stopIndex - startIndex) % 3 != 0 && stopIndex != -1) {
            stopIndex =  dna.indexOf("TAA", stopIndex + 3);
            if (stopIndex == -1) gene = "";  // no "TAA"             
        }
        if (stopIndex != -1 && (stopIndex - startIndex) % 3 == 0) gene = dnaOrig.substring(startIndex, stopIndex + 3);
    }
    return gene; 
    }
    
    public boolean twoOccurrences(String stringa, String stringb){
        int count = 0, start = 0;
        boolean result = false; 
        for (int i = start; i < stringb.length(); i++){
            if (stringb.indexOf(stringa, start) != -1) {
                count++;
                start = stringb.indexOf(stringa) + stringa.length();                
            } 
        }
        if (count >= 2) result = true;
        return result;
    }
    
    public String lastPart(String stringa, String stringb){
        int start = 0;        
            if (stringb.indexOf(stringa) != -1){
            start = stringb.indexOf(stringa) + stringa.length();
            stringb = stringb.substring(start);
            }  
        return stringb;
    }
    
    public void checkUrl(){
        URLResource url = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String uWord : url.words()){
            String word = uWord.toLowerCase();
            if (word.contains("youtube.com")){
                String link = word.substring(word.indexOf("\""), word.lastIndexOf("\"") + 1);
                System.out.println(link);
            }
        }
    }

    public void testFindGeneSimple(){
        System.out.println();
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        if (gene == "") System.out.println("There is no Gene.");
        else System.out.println("Gene is " + gene + ".");
        
        dna = "ATGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        if (gene == "") System.out.println("There is no Gene.");
        else System.out.println("Gene is " + gene + ".");
        // no "ATG"
        dna = "TGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        if (gene == "") System.out.println("There is no Gene.");
        else System.out.println("Gene is " + gene + ".");
        // no "TAA"
        dna = "ATGTA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        if (gene == "") System.out.println("There is no Gene.");
        else System.out.println("Gene is " + gene + ".");
        
        dna = "AATGCGTAATTAATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        if (gene == "") System.out.println("There is no Gene.");
        else System.out.println("Gene is " + gene + ".");
        
        dna = "atgctataa";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        if (gene == "") System.out.println("There is no Gene.");
        else System.out.println("Gene is " + gene + ".");
        
        dna = "atgCTAtaa";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        if (gene == "") System.out.println("There is no Gene.");
        else System.out.println("Gene is " + gene + ".");
        
        dna = "AATGCGTAATATGGT";
        String dna1 = "ATG";
        System.out.println("\nString1 = " + dna + "\nString2 = " + dna1 
        + "\nTwo occurances is " + twoOccurrences(dna1, dna));
        
        dna = "AATGCGTAATATGGT";
        dna1 = "TAA";
        System.out.println("\nString1 = " + dna + "\nString2 = " + dna1 
        + "\nTwo occurances is " + twoOccurrences(dna1, dna));
        
        dna = "AATGCGTAATATGGT";
        dna1 = "TAA";
        System.out.println("\nString1 = " + dna + "\nString2 = " + dna1 
        + "\nString1 - String2 = " + lastPart(dna1, dna));
        
        dna = "AATGCGTATATGGT";
        dna1 = "TAA";
        System.out.println("\nString1 = " + dna + "\nString2 = " + dna1 
        + "\nString1 - String2 = " + lastPart(dna1, dna));
    }
}
