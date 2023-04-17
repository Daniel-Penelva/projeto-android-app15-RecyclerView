package com.formacaoandroidstudio.recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.formacaoandroidstudio.recyclerview.R;
import com.formacaoandroidstudio.recyclerview.activity.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }


    /* Método chamado para criar as visualizações, ou seja, que recupera os dados */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
    /* O método get recupera a posição da lista, vai ser passado o position para definir o total da lista.   */
        Filme filme = listaFilmes.get(position);

    /* Recupera os dados da lista */
        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());
    }

    public int getItemCount(){
    /* Descobre o tamanho da lista */
        return listaFilmes.size();
    }

    /* Recuperar os componentes de tela (adapter_lista.xml) */
    public class MyViewHolder extends RecyclerView.ViewHolder{

        //Atributos dos dados do ViewHolder
        TextView titulo;
        TextView genero;
        TextView ano;

        // Construtor - acessa o objeto view, ou seja, é dentro do 'itemView' que acessa os ids dos componentes
        public MyViewHolder(View itemView){

            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            genero = itemView.findViewById(R.id.textGenero);
            ano = itemView.findViewById(R.id.textAno);

        }
    }
}

/* Anotações:
* Quando se utiliza um RecycleView cada um dos itens exibidos vai ser
* exibindo um ViewHolder (VH).
*
* Portanto,
* Vai ser criado a visualização que irá aparecer na tela do seu app e a partir do momento
* que você rola para baixo ou rola para cima (lista de itens), ele pega essas visualizações disponíveis e vai
* reaproveitando, mudando apenas os dados. E cada elemento dessa lista (ou cada item dessa lista) os dados
* que estão nessa lista serão preciso usar um ViewHolder (armazenar cada um desses itens). Então, precisamos
* do ViewHolder para reaproveitar as views, mas os dados precisam alterar.
*
* Vamos utilizar a Classe 'MyViewHolder' para criar esses itens. Ou seja, os itens (os objetos) eles vão mudando automaticamente
* e essa classe vai ser usada para salvar esses dados. Vai ser criado uma classe dentro da outra classe.
*
* Essa classe vai salvar os seguinte dados: o nome do Filme, o gênero do filme e a data do filme.
*
* Vamos precisar agora criar um layout adapter, para isso vamos no pacote:
*  res > layout > layout resource File > nomear de 'adapter_list' > Root Element e digitar LinearLayout > ok
*
* Na Classe MyViewHolder:
*
* Temos que retornar essa visualização do adapter_lista.xml, ou seja, temo que retorna esse arquivo .xml para cada um
* desses itens de lista. Primeiro é preciso converter esse arquivo adapter_lista.xml em um objeto do tipo View. Para
* converter é preciso usar uma classe LayoutInflater, sua função é inflar o xml em uma visualização. Portanto, é a classe
* responsável por criar uma View a partir de um arquivo XML, portanto, você precisa dele para instanciar e acessar uma View.
*
* Vamos usar um getContext que é chamado nos componentes visuais mais internos de uma atividade, como views e fragments.
* E por fim o método inflate() que recebe três parâmetros, são eles: (1) item de lista (2)View (parent)  (3) boolean (false).
*
* Portanto,
          OnCreateViewHolder - Ele apenas cria a visualização.
          OnBindViewHolder - Ele exibe a visualização dos itens.
          getItemCount - Mostra a quantidade de itens que vai ser exibido
*
* */