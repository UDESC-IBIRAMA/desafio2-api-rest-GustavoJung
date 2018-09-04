package br.udesc.ceavi.dsw.model;

import br.udesc.ceavi.dsw.model.Modelo;
import br.udesc.ceavi.dsw.model.Montadora;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-04T17:05:48")
@StaticMetamodel(Veiculo.class)
public class Veiculo_ { 

    public static volatile SingularAttribute<Veiculo, Double> motor;
    public static volatile SingularAttribute<Veiculo, Long> id_veiculo;
    public static volatile SingularAttribute<Veiculo, String> tipo;
    public static volatile SingularAttribute<Veiculo, String> cor;
    public static volatile SingularAttribute<Veiculo, Montadora> montadora;
    public static volatile SingularAttribute<Veiculo, Integer> quilometragem;
    public static volatile SingularAttribute<Veiculo, Modelo> modelo;

}