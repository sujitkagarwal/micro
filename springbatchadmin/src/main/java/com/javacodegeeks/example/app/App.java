package com.javacodegeeks.example.app;

import com.javacodegeeks.example.util.GenerateData;

public class App {
  public static void main(String[] args) {
	//generate data
	GenerateData data = new GenerateData();
	data.getSampleData("/Users/sujitagarwal/workspace/SpringBatchAdmin/src/main/resources/DATA/sampleData.csv");


  }
}
