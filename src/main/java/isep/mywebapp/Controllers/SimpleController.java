package isep.mywebapp.Controllers;

import isep.mywebapp.Models.Emp;
import isep.mywebapp.Repositories.EmpRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SimpleController {
    @Autowired
    private EmpRepository empRepository;

    @RequestMapping(value="/?name={name}", method= RequestMethod.GET)
    public String hello(@PathVariable(value = "name", required = false) String name) {
        return "Hello " + name;
    }

    @RequestMapping(value="/employees", method= RequestMethod.GET)
    public List<Emp> getEmployees() {
        return empRepository.findAll();
    }

    @PutMapping(value="/employees")
    public Emp addEmployee(@RequestBody Emp emp) {
        return empRepository.save(emp);
    }

    @GetMapping(value="/employee/{id}")
    public Optional<Emp> getEmployee(@PathVariable Long id){
        return empRepository.findById(id);
    }

    @PostMapping(value="/employee/update/{id}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable Long id, @RequestBody Emp newEmp){
        try{
            Optional<Emp> emp = empRepository.findById(id);
            if(emp.isPresent()) {
                emp.get().setEname(newEmp.getEname());
                emp.get().setJob(newEmp.getJob());
                emp.get().setSal(newEmp.getSal());
                emp.get().setMgr(newEmp.getMgr());
                emp.get().setEmpno(newEmp.getEmpno());
                emp.get().setEfirst(newEmp.getEfirst());
                empRepository.save(emp.get());
            }
        } catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        } finally {
            return ResponseEntity.ok("Employee number "+ id + " has been updated to: "+ newEmp);
        }
    }
    @PostMapping(value="/employee/updateName/{id}/{fName}")
    public ResponseEntity<String> updateEmployeeFnameById(@PathVariable Long id, @PathVariable String fName){
        try{
            Optional<Emp> emp = empRepository.findById(id);
            emp.get().setEfirst(fName);
            empRepository.save(emp.get());
        } catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        } finally {
            return ResponseEntity.ok("Employee number "+ id + "'s firstName has been update to "+ fName);
        }
    }

    @DeleteMapping(value="/employee/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
        try{
            empRepository.deleteById(id);
        } catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        } finally {
            return ResponseEntity.ok("Employee number "+id+ " has been deleted");
        }
    }

    @DeleteMapping(value="/employee/delete")
    public ResponseEntity<String> deleteEmployee(@RequestBody Emp emp){
        try{ empRepository.deleteById(emp.getEmpno()); }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        } finally {
            return ResponseEntity.ok("Employee "+emp+ " has been deleted");
        }
    }
}


