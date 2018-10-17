package com.codingcompetition.statefarm;

import com.codingcompetition.statefarm.model.PointOfInterest;
import com.codingcompetition.statefarm.utility.PointOfInterestParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StreetMapDataInterpreter implements Interpreter {
    private List<PointOfInterest> poi;

    /**
     * Creates a new <code>StreetMapDataInterpreter</code> that takes in an XML
     * file and parses it for its locations
     *
     * @param s the name of the XML file
     */
    public StreetMapDataInterpreter(String s) {
        PointOfInterestParser parser = new PointOfInterestParser();
        try{
            poi = parser.parse(s);
            System.out.println("now");
        } catch(Exception e) {
            e.printStackTrace();
        }//try catch

    }//StreetMapDataInterpreter

    @Override
    public List<PointOfInterest> interpret() {
        System.out.println("method");
        return poi;
    }//interpret

    @Override
    public List<PointOfInterest> interpret(SearchCriteria criteria) {
        if(criteria == null) {
            return new ArrayList<>();
        } //if criteria is null

        ArrayList<PointOfInterest> results = new ArrayList<>();
        for (PointOfInterest curr: poi) {
            String k = criteria.getCat().name().toLowerCase();
            String v = criteria.getValue();
            String currValue = curr.getDescriptors().get(k);

            if(currValue !=  null && v.equals(currValue)) {
                results.add(curr);
            } //if currValue is not null and v equals currValue

        } //for each element i  poi

        return results;
    }//interpret

    @Override
    public List<PointOfInterest> interpret(Map<Integer, SearchCriteria> prioritizedCriteria) {
        return null;
    }//interpret

    @Override
    public List<PointOfInterest> findByCriterias(List<SearchCriteria> criterias) {
        return null;
    }//findByCriterias
} //StreetMapDataInterpreter
