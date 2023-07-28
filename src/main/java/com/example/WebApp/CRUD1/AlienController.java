package com.example.WebApp.CRUD1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;
    @RequestMapping("/home")
    public String home()
    {
        return "home -> to return this as JSP add Jasper to pom";
    }

    @RequestMapping("/addAlien")
    public String addAlienMVC(Alien alien)
    {
        repo.save(alien);
        return "home";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid)
    {
        ModelAndView mv = new ModelAndView("display");
        Alien  alien = repo.findById(aid).orElse(new Alien());
        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/deleteAlien")
    public ModelAndView deleteAlienMVC(@RequestParam int aid)
    {
        ModelAndView mv = new ModelAndView("delete");
        Alien  alien = repo.findById(aid).orElse(new Alien());
        repo.deleteById(aid);
        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/updateAlien")
    public ModelAndView updateAlienMVC(Alien alien)
    {
        ModelAndView mv = new ModelAndView("display");
        repo.save(alien);
        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/customGetAlien")
    @ResponseBody
    public void customGetAlien()
    {
        System.out.println(repo.findByAname("Ravi"));;
        System.out.println(repo.findByTech("Java"));
        System.out.println(repo.findByAidGreaterThan(2));
        System.out.println(repo.findByTechSortedByName("Java"));
    }


    //Till Above we were dealing with Spring MVC
    //From Below we will deal with Spring Boot




//    @RequestMapping("/aliens")
//    @ResponseBody
//    public String getAliens()
//    {
//        return repo.findAll().toString();
//    }
//
//    @RequestMapping("/alien/{aid}")
//    @ResponseBody
//    public String getAlienById(@PathVariable("aid") int aid)
//    {
//        return repo.findById(aid).toString();
//    }


    //till above we were using CRUD Repository and from below we will use JPARepository
    //Jackson in Maven dependecy is changing the List<Alien> to json value
//    @RequestMapping("/aliens")
//    @ResponseBody
//    public List<Alien> getAliens()
//    {
//        return repo.findAll();
//    }

//    @RequestMapping("/alien/{aid}")
//    @ResponseBody
//    public Optional<Alien> getAlienById(@PathVariable("aid") int aid)
//    {
//        return repo.findById(aid);
//    }

    //The above functions implementation id done below using get and postmapping

    //Content Negotiation is requesting server to provide data in format we ask like json,xml,pdf etc...
    //Jackson-xml converter needs to use in pom.xml to send the data from server in xml format as Spring by default supports only json

//    @RequestMapping(path = "/aliens", produces = {"application/xml"})
//    @ResponseBody
//    public List<Alien> getAliensInXml()
//    {
//        return repo.findAll();
//    }

    //Above one is just to restrict the data to send from server in XML format

//    @RequestMapping(value = "alien", method = RequestMethod.POST)
//    public void addAlien(Alien alien)
//    {
//        repo.save(alien);
//    }

    @GetMapping("aliens")
    public List<Alien> getAliens()
    {
        return repo.findAll();
    }

    @GetMapping("alien/{aid}")
    public Optional<Alien> getAlienById(@PathVariable("aid") int aid)
    {
        return repo.findById(aid);
    }

    @PostMapping("alien") //consumes = {"application/xml"} to consume only xml
    public Alien addAlien(@RequestBody Alien alien) //Here @RequestBody is to take the raw body pass from Client.
    {
        repo.save(alien);
        return alien;
    }

    @PutMapping("alien")
    public Alien updateAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return alien;
    }

    @DeleteMapping("alien/{aid}")
    public Optional<Alien> deleteAlien(@PathVariable int aid)
    {
        Optional<Alien> alien = repo.findById(aid);
//        Alien alien = repo.getOne(aid);
        repo.deleteById(aid);
        return alien;
    }
}
