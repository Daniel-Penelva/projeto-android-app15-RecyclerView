package com.formacaoandroidstudio.recyclerview.activity.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }


    /* Método chamado para criar as visualizações */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){

    }

    public int getItemCount(){
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //Atributos dos dados do ViewHolder
        TextView nome;
        TextView genero;
        TextView data;

        // Construtor
        public MyViewHolder(View itemView){
            super(itemView);
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
* */