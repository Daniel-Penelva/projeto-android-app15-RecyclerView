package com.formacaoandroidstudio.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.formacaoandroidstudio.recyclerview.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Configurar Adapter


        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        /*use esta configuração para melhorar o desempenho se você souber que as alterações no conteúdo não alteram o
        tamanho do layout do RecyclerView. Ou seja, otimiza o RecyclerView para um tamanho fixo. */
        recyclerView.setHasFixedSize(true);

        //recyclerView.setAdapter();
    }
}

/**
 * Anotações:
 *
 * O RecyclerView, como o nome indica, recicla esses elementos individuais. Quando um item rola para fora da tela,
 * o RecyclerView não destrói a visualização dele. Em vez disso, o RecyclerView reutiliza a visualização para novos
 * itens que passaram a aparecer na tela. Isso melhora muito o desempenho, aperfeiçoando a capacidade de resposta do
 * app e reduzindo o consumo de energia.
 *
 * Classes principais
 * Diversas classes diferentes funcionam juntas para criar sua lista dinâmica.
 *
 *  -> RecyclerView é o ViewGroup que contém as visualizações correspondentes aos seus dados. Ela é uma visualização em
 *     si, então adicione a RecyclerView ao layout da mesma forma que você adicionaria qualquer outro elemento da IU.
 *
 *  -> Cada elemento individual da lista é definido por um objeto fixador de visualização. Quando o fixador de visualização
 *     é criado, ele não tem dados associados a si mesmo. Depois que o fixador de visualização é criado, o RecyclerView o
 *     vincula aos dados. Para definir o fixador de visualização, estenda RecyclerView.ViewHolder.
 *
 *  -> O RecyclerView solicita essas visualizações e vincula as visualizações aos dados delas, chamando métodos no adaptador.
 *     Para definir o adaptador, estenda RecyclerView.Adapter.
 *
 *  -> O gerenciador de layout organiza os elementos individuais na sua lista. Você pode usar um dos gerenciadores de layout
 *     fornecidos pela biblioteca RecyclerView ou pode definir seu próprio gerenciador. Todos os gerenciadores de layout
 *     são baseados na classe abstrata LayoutManager da biblioteca.
 *
 * Os itens na RecyclerView são organizados por uma classe LayoutManager. A biblioteca RecyclerView fornece três
 * gerenciadores de layout, que processam as situações de layout mais comuns:
 *
 *  -> LinearLayoutManager organiza os itens em uma lista unidimensional.
 *
 *  -> GridLayoutManager organiza todos os itens em uma grade bidimensional:
 *       . Se a grade for organizada na vertical, GridLayoutManager tentará fazer com que todos os elementos em cada
 *         linha tenham a mesma largura e altura, mas linhas diferentes podem ter alturas diferentes.
 *
 *       . Se a grade for organizada na horizontal, GridLayoutManager tentará fazer com que todos os elementos em cada
 *         coluna tenham a mesma largura e altura, mas colunas diferentes podem ter larguras diferentes.
 *
 *   -> StaggeredGridLayoutManager é semelhante a GridLayoutManager, mas não exige que os itens de uma linha tenham a
 *      mesma altura (para grades verticais) ou itens na mesma coluna tenham a mesma largura (para grades horizontais).
 *      O resultado é que os itens em uma linha ou coluna podem acabar afastados um do outro.
 *
 *Implementar o adaptador e o fixador de visualização
 * Depois de determinar seu layout, é necessário implementar o Adapter e o ViewHolder. Essas duas classes trabalham juntas
 * para definir como seus dados são exibidos. O ViewHolder é um wrapper em torno da View que contém o layout de um item
 * individual na lista. O Adapter cria objetos ViewHolder conforme necessário e também define os dados para essas visualizações.
 * O processo de associação de visualizações aos dados é chamado de vinculação.
 *
 * Ao definir o adaptador, você precisa modificar três métodos principais:
 *
 *    -> onCreateViewHolder(): RecyclerView chama esse método sempre que precisa criar um novo ViewHolder. O método cria e
 *       inicializa o ViewHolder e a View associada, mas não preenche o conteúdo da visualização. O ViewHolder ainda não
 *       foi vinculado a dados específicos.
 *
 *    -> onBindViewHolder(): RecyclerView chama esse método para associar um ViewHolder aos dados. O método busca os dados
 *       apropriados e usa esses dados para preencher o layout do fixador de visualização. Por exemplo, se a RecyclerView
 *       exibir uma lista de nomes, o método poderá encontrar o nome apropriado na lista e preencher o widget TextView do
 *       fixador de visualização.
 *
 *   -> getItemCount(): a RecyclerView chama esse método para ver o tamanho do conjunto de dados. Por exemplo, em um app
 *      de lista de endereços, pode ser o número total de endereços. O RecyclerView usa essa função para determinar quando
 *      não há mais itens a serem exibidos.
 *
 **/