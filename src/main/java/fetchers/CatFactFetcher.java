
package fetchers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CatFactDTO;
import dto.StandartDTO;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import utils.HttpUtils;

/**
 *
 * @author miade
 */
public class CatFactFetcher {
    private static final String FACT_SERVER = "https://cat-fact.herokuapp.com/facts/random";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    public static String responseFromExternalServerParrallel(ExecutorService threadPool, final Gson gson) throws Exception{
        long start = System.nanoTime();
        
        Callable<CatFactDTO> factTask = new Callable<CatFactDTO>(){
            @Override
            public CatFactDTO call() throws Exception {
                String randomCatFact = HttpUtils.fetchData(FACT_SERVER);
                CatFactDTO catFactDTO = GSON.fromJson(randomCatFact, CatFactDTO.class);
                return catFactDTO;
            }
            
        };
        Future<CatFactDTO> futureFact = threadPool.submit(factTask);
        
        CatFactDTO catFact = futureFact.get(2, TimeUnit.SECONDS);
        
        long end = System.nanoTime(); 
        String time = "Time Parallel: " + ((end-start)/1_000_000) + " ms.";
        
        StandartDTO sDTO = new StandartDTO(catFact, time);
        
        String standartJSON = gson.toJson(sDTO);
          
        return standartJSON;
    }
    
}
