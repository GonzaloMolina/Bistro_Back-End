package Bistro_BackEnd.controladores.empleado;

import Bistro_BackEnd.servicios.empleado.MozoService;
import Bistro_BackEnd.servicios.excepciones.ExcepcionIdInvalida;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mozo")
@CrossOrigin(origins = "*")
public class ControladorDeMozo {
    @Autowired
    private MozoService mozoService;

    //get_ALL
    @GetMapping(value = "/list", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = MozoResponseBodyList.class, responseContainer = "List"),
    })
    public ResponseEntity<List> listMozos() {
        return new ResponseEntity<> (mozoService.listAll(), HttpStatus.OK);
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a user",response = MozoResponseBody.class),
    })
    public ResponseEntity<MozoResponseBody> getMozo(@PathVariable Integer id) throws ExcepcionIdInvalida {
        return new ResponseEntity<>(mozoService.getById(id), HttpStatus.OK);
    }
}