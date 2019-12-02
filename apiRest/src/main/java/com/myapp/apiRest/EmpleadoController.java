package com.myapp.apiRest;

import com.myapp.apiRest.dominio.Empleados;
import com.myapp.apiRest.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoRepository empleadosrepository;
    /*  Metodo HTTP Get */
    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
    @ResponseBody
        public ResponseEntity<?> traerEmpleados(){
        try{
            List<Empleados> empList = empleadosrepository.findAll();
            return new ResponseEntity<>(empList, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*  Metodo HTTP Get by id */
    @RequestMapping(value = "/empleados/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> traerEmpleados(@PathVariable long id){
        try{
            Optional<Empleados> empList = empleadosrepository.findById(id);
            return new ResponseEntity<>(empList, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*  Metodo HTTP Post */
    @RequestMapping(value = "/empleados/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> guardarEmpleados(@RequestBody Empleados body){
        try{
            return new ResponseEntity<>(empleadosrepository.save(body), HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*  Metodo HTTP Update */
    @RequestMapping(value = "/empleados/put", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> modificarEmpleados(@RequestBody Empleados body){
        try{
            return new ResponseEntity<>(empleadosrepository.save(body), HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*  Metodo HTTP Delete */
    @RequestMapping(value = "/empleados/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id){
        try{
            empleadosrepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
