/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fetchers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.KanyeRestDTO;
import dto.StandartDTO;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import utils.HttpUtils;

/**
 *
 * @author Selina A.S.
 */


public class KanyeRestFetcher {
  private static final String FACT_SERVER = "https://api.kanye.rest";
  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
 
  public static String responseFromExternalServerParrallel(ExecutorService threadPool, final Gson gson) throws Exception{
  long start = System.nanoTime();
        
    Callable<KanyeRestDTO> factTask = new Callable<KanyeRestDTO>(){
               
    @Override
    public KanyeRestDTO call() throws IOException {
       String kanyeRestAPI = HttpUtils.fetchData(FACT_SERVER);
       KanyeRestDTO kwDTO = GSON.fromJson(kanyeRestAPI, KanyeRestDTO.class);
       return kwDTO;
        
            
    }
   };
    
     Future<KanyeRestDTO> futureFact = threadPool.submit(factTask);
        
        KanyeRestDTO kanyeFact = futureFact.get(2, TimeUnit.SECONDS);
        
        long end = System.nanoTime(); 
        String time = "Time Parallel: " + ((end-start)/1_000_000) + " ms.";
        
        StandartDTO sDTO = new StandartDTO(kanyeFact, time);
        
        String standartJSON = gson.toJson(sDTO);
          
        return standartJSON;
    }
}
