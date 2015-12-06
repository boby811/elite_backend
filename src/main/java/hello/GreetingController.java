package hello;

import hello.mapper.VillageMapper;
import hello.pojo.Village;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello , %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public List<Village> greeting(@RequestParam(value="name", defaultValue="World") String name) {
 	   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
 	   ctx.register(AppConfig.class);
 	   ctx.refresh();
 	   VillageMapper mapper = ctx.getBean(VillageMapper.class);	
// 	   Village village = new Village();
// 	   village.setVid(2);
// 	   village.setVillageName("TOTO");
// 	   village.setDistrict("tutu");
// 	   mapper.insertVillage(village);
 	   Village villageAreturn = new Village();
 	   List<Village> listeVillage = mapper.selectAllVillage();
            System.out.println("---Data saved---");
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
            return listeVillage;
    }
}