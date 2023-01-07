package be.abd.helbdemo.Controller;

import be.abd.helbdemo.Model.*;
import be.abd.helbdemo.dao.*;
import be.abd.helbdemo.service.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HomeController {





    /*@GetMapping("students/Paul")
    public List<Student> student()
    {
     return studentDAO.findByName("Paul");
    }*/




    /*@GetMapping("home")
    public String home(@RequestParam(defaultValue = "Hello World") String name)
    {
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM/dd/yyyy");
        String s = dtfOut.print(DateTime.now());
        return "Hello World " + name + " " + s;
    }*/

   /* @GetMapping("employes")
    public List<Employe> employe()
    {

        return employeDAO.findAll();

    }*/

    /*@PostMapping("/employes")
    public Employe addEmploye(@RequestBody Employe e)
    {

        return employeDAO.save(e);

    }*/



   /* @GetMapping("students")
    public List<Student> student(@RequestParam(defaultValue = "paul") String firstname)
    {

        return studentDAO.findByfirstname(firstname);
    }*/

    /*@GetMapping("students/before/2006-03-14")
    public List<Student> student()
    {

        return studentDAO.findAllWithCreationDateTimeBefore(LocalDate.of(2006, 03, 14));
    }*/

    /*@GetMapping("students/after/2006-03-14")
    public List<Student> student()
    {

        return studentDAO.findAllWithCreationDateTimeAfter(LocalDate.of(2006, 03, 14));
    }*/

   /* @GetMapping("students/mail/end/.be")
    public List<Student> student()
    {

        return studentDAO.findByMailContaining(".be");
    }
*/

}
