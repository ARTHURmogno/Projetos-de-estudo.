package main.java.com.UMBRELLA.InforHubAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String titulo;
   private String sinopse;
   private String genero;
   private int duracao;
   private String ondeAssistir;

   public Filme {
   }

   public Filme(String titulo, String sinopse, String genero, int duracao, String ondeAssistir) {
    this.titulo = titulo;
    this.sinopse = sinopse;
    this.genero = genero;
    this.duracao = duracao;
    this.ondeAssistir = ondeAssistir;

   }

   public String getTitulo() {
    return titulo;
   }

   public String getSinopse() {
    return sinopse;
   }

   public String getGenero() {
    return genero;
   }

   public int getDuracao() {
    return duracao;
   }

   public String getOndeAssistir() {
    return ondeAssistir;
   }

    public void setOndeAssistir(String ondeAssistir) {
        this.ondeAssistir = ondeAssistir;
   }

   


}
