package br.udesc.ceavi.dsw.model;

import br.udesc.ceavi.dsw.model.Veiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-04T17:05:48")
@StaticMetamodel(Modelo.class)
public class Modelo_ { 

    public static volatile ListAttribute<Modelo, Veiculo> veiculos;
    public static volatile SingularAttribute<Modelo, Long> id_modelo;
    public static volatile SingularAttribute<Modelo, String> nome;

}