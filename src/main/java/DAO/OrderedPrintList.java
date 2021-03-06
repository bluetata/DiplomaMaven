package DAO;

import Model.AllelePrintMap;
import Model.AlleleReverseNamesMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Contains logic for ordering print according to allele name taken either from <Object>AllelePrintMap
 * </Object> or <Object>AlleleReverseNamesMap</Object>
 * @author andriylazorenko
 */

public class OrderedPrintList {
    private Set<String> names = new LinkedHashSet<>();
    AllelePrintMap apm = new AllelePrintMap();
    AlleleReverseNamesMap arnm = new AlleleReverseNamesMap();
    String variationAllele;
    public OrderedPrintList(String variationAllele){
        this.variationAllele = variationAllele;
        try {//TODO rewrite the following comment
            if (!apm.getAllelePrint().keySet().contains(variationAllele)){//� ������, ����� ������ ���������� � Allele, ��������� �������� �������������� ���������� �����
                variationAllele = arnm.getAlleleNames().get(variationAllele).toString();
            }
            FileReader fr = new FileReader(apm.getAllelePrint().get(variationAllele));
            BufferedReader br = new BufferedReader(fr);
            String line=(br.readLine());
            while (line != null) {
                names.add(line);
                line=br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Set<String> orderedPrintSequence(){
        return names;
    }
}
