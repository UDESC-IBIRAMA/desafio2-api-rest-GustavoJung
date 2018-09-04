/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.webservice;

import br.udesc.ceavi.dsw.model.Modelo;
import br.udesc.ceavi.dsw.model.Montadora;
import br.udesc.ceavi.dsw.model.Veiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author GUSTAVO JUNG
 */
@Stateless
@Path("/veiculo")
public class VeiculoFacadeREST extends AbstractFacade<Veiculo> {

    @PersistenceContext(unitName = "DesafioPU")
    private EntityManager em;

    public VeiculoFacadeREST() {
        super(Veiculo.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Veiculo entity) {
        super.create(entity);
    }

    //
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    //busca por id do veiculo
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo find(@PathParam("id") Long id) {
        return super.find(id);
    }
    //busca por cor do veiculo
    @GET
    @Path("cor/{cor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findCor(@PathParam("cor") String cor){  
        return super.findCor(cor);
    }
    //busca por cor e por ti
    @GET
    @Path("buscaTipoCor/{tipo}/{cor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findTipoeCor(@PathParam("tipo")String tipo,@PathParam("cor") String cor){
        return super.findTipoeCor(tipo, cor);
    }
    
    //busca por tipo e km
     @GET
    @Path("buscaTipoQuilometragem/{tipo}/{quilometragem}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findTipoeQuilometragem(@PathParam("tipo")String tipo,@PathParam("quilometragem")int quilometragem){
        return super.findTipoeQuilometragem(tipo, quilometragem);
    }
     //busca por tipo tipo e motor
    @GET
    @Path("buscaTipoMotor/{tipo}/{motor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findTipoeMotor(@PathParam("tipo")String tipo,@PathParam("motor")double motor){
        return super.findTipoeMotor(tipo,motor);
    }
    //busca por tipo e montadora
    @GET
    @Path("buscaTipoMontadora/{tipo}/{montadora}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findTipoeMontadora(@PathParam("tipo")String tipo,@PathParam("montadora")String nome_montadora){
        return super.findTipoeMontadora(tipo, nome_montadora);
    }
    
    //busca por km minima
    @GET
    @Path("quilometragem/valor-minimo")
    public List<Veiculo> veiculosQuilometragemMaiorQue(@QueryParam("minimo") int minValue) {
        return super.quilometragemMinima(minValue);
    }
    
    //busca por km maxima
    @GET
    @Path("quilometragem/valor-maximo")
    public List<Veiculo> veiculosQuilometragemMenorQue(@QueryParam("maximo") int maxValue){
        return super.quilometragemMaxima(maxValue);
    }
    
    //busca por motor minimo
    @GET
    @Path("motor/valorMinimo")
    public List<Veiculo> veiculosMotorMinimo(@QueryParam("minimo")double minValue){
        return super.motorMinimo(minValue);
    }
    
    //busca por motor maximo
    @GET
    @Path("motor/valorMaximo")
    public List<Veiculo> veiculosMotorMaximo(@QueryParam("maximo")double maxValue){
        return super.motorMaximo(maxValue);
    }
    //busca por motor
    @GET
    @Path("motor/{motor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findMotor(@PathParam("motor") double motor) {
        return super.findMotor(motor);
    }
    // busca por km
    @GET
    @Path("quilometragem/{quilometragem}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findQuilometragem(@PathParam("quilometragem")int quilometragem){
        return super.findQuilometragem(quilometragem);
    }
    //busca por modelo
    @GET
    @Path("modelo/{nome_modelo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findModelo(@PathParam("nome_modelo")String nome_modelo){
        return super.findModelo(nome_modelo);
    }
    //busca por montadora
    @GET
    @Path("montadora/{nome_montadora}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findMontadora(@PathParam("nome_montadora")String nome_montadora){
        return super.findMontadora(nome_montadora);
    }
    
  
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findAll() {
        return super.findAll();
    }
    /*
    @GET
    @Path("/range/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
