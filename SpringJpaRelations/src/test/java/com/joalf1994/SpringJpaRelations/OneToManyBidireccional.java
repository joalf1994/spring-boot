package com.joalf1994.SpringJpaRelations;

import com.joalf1994.SpringJpaRelations.model.Cliente;
import com.joalf1994.SpringJpaRelations.model.Pedido;
import com.joalf1994.SpringJpaRelations.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class OneToManyBidireccional {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void insertar() {
        Pedido p1 = new Pedido("E00-1", "caja de leche", 20D);
        Pedido p2 = new Pedido("E00-2", "caja de agua", 10D);
        Pedido p3 = new Pedido("E00-3", "caja de vino", 15D);

        Cliente cliente = new Cliente("101010", "Carlos");

        p1.setCliente(cliente);
        p2.setCliente(cliente);
        p3.setCliente(cliente);

        cliente.setPedidos(List.of(p1, p2, p3));


        clienteRepository.save(cliente);

        Optional<Cliente> clienteDb = clienteRepository.findById(cliente.getId());
        Pedido pedidoAux = null;
        int cont = 0;
        if (clienteDb.isPresent()) {
            List<Pedido> pedidoList = clienteDb.get().getPedidos().stream().filter(pedido -> pedido.getNroPedido().equals("E00-2")).toList();
            System.out.println("Pedidos: " + pedidoList.toString());
            System.out.println("Cliente: " + pedidoList.get(0).getCliente().getNombre());
        }


    }
}

