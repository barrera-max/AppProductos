package AppProductos.Services;

import AppProductos.Entities.Producto;
import AppProductos.Repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServices {

    @Autowired
    IProductoRepository productoRepository;

    public List<Producto> getALL(){
       List<Producto> lista = productoRepository.findAll();
       //agregar codgo
       return lista;
    }

    public Producto createProducto(Producto p){
        return productoRepository.save(p);
    }

    //devuelve el tipo esperado o bien puede devolver null
    public Optional<Producto> getById(Integer id){

        return productoRepository.findById(id);
    }
    public Optional<Producto> updateById(Producto req,Integer id){
        Optional<Producto> producto = productoRepository.findById(id);

        producto.ifPresent(p -> {
            p.setCodigo(req.getCodigo());
            p.setNombre(req.getNombre());
            p.setPrecio(req.getPrecio());
            productoRepository.save(p);
        });
        return producto;
    }

    public void deleteProducto(Integer id){
        this.productoRepository.deleteById(id);
    }

}



