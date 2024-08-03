package AppProductos.Controllers;

import AppProductos.Entities.Producto;
import AppProductos.Services.ProductoServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductoController {


    private final ProductoServices productoServices;

    public ProductoController(ProductoServices productoServices) {
        this.productoServices = productoServices;
    }

    @GetMapping(value = "/productos")
    public ResponseEntity<List<Producto>> consultarTodos() {
        try {
            List<Producto> list = this.productoServices.getALL();
            return ResponseEntity.ok(list);
        } catch (NoSuchElementException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/productos")
    public ResponseEntity<Producto> createUser(@RequestBody Producto producto) {
        try {
            this.productoServices.createProducto(producto);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/productos/{id}")
    public ResponseEntity<Optional<Producto>> buscar(@PathVariable Integer id) {
        try {
            Optional<Producto> p = this.productoServices.getById(id);
            if (p.isPresent()) {
                return ResponseEntity.ok(p);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/productos/{id}")
    public ResponseEntity<Optional<Producto>> updateProductoById(@RequestBody Producto producto, @PathVariable Integer id) {
        try {
            Optional<Producto> pUpdate = this.productoServices.updateById(producto, id);
            if (pUpdate.isPresent()) {
                return ResponseEntity.ok(pUpdate);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value = "/productos/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Integer id) {
        try {
            this.productoServices.deleteProducto(id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
