package com.bridgelabz;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CensusAnalyzerTest {
    private static final String INDIA_CENSUS_CSV_WRONG_FILETYPE = "F:\\indian-state-census-analyzer\\src\\main\\resources\\IndiaStateCensusData.pdf";
    private static final String INDIA_CENSUS_CSV_PATH = "F:\\indian-state-census-analyzer\\src\\main\\resources\\IndiaStateCensusData.csv";


    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(29, numOfRecord);
        } catch (CensusAnalyzerException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenIndianCensusCSVFileReturnsInCorrectRecords() {
        CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertNotEquals(30, numOfRecord);
        } catch (CensusAnalyzerException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenIndianCensusCSVFileReturnsInCorrecFileType_But_PathShouldBeCorrect() {
        CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_WRONG_FILETYPE);
            Assert.assertEquals(29, numOfRecord);
        } catch (CensusAnalyzerException e) {
            e.printStackTrace();
        }
    }
}