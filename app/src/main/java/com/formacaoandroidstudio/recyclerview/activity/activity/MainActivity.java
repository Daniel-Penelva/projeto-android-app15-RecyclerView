package com.formacaoandroidstudio.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.formacaoandroidstudio.recyclerview.R;
import com.formacaoandroidstudio.recyclerview.activity.ClickListener;
import com.formacaoandroidstudio.recyclerview.activity.adapter.Adapter;
import com.formacaoandroidstudio.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Listagem de Filmes
        this.criarFilmes();

        // Configurar Adapter
        // Vamos utilizar o adapter (com.formacaoandroid.recycleview) que você criou e não o Adapter<VH>
        Adapter adapter = new Adapter(listaFilmes);


        /* Configurar RecyclerView */
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        /* use esta configuração para melhorar o desempenho se você souber que as alterações no conteúdo não alteram o
        tamanho do layout do RecyclerView. Ou seja, otimiza o RecyclerView para um tamanho fixo. */
        recyclerView.setHasFixedSize(true);

        /* Criar um divisor na tela para melhor visualização */
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        /* Evento de Click para mostrar através do Toast o nome do Título do filme*/
        recyclerView.addOnItemTouchListener(new ClickListener(getApplicationContext(), recyclerView, new ClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               // Instancia um filme
                Filme filme = listaFilmes.get(position);
               // Cria um Toast e captura pelo getTituloFilme
                Toast.makeText(getApplicationContext(), "Item Pressionado - " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                // Instancia um filme
                Filme filme = listaFilmes.get(position);
                // Cria um Toast e captura pelo getTituloFilme
                Toast.makeText(getApplicationContext(), "Click Long - " + filme.getTituloFilme(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    public void criarFilmes(){

        Filme filme;

        filme = new Filme("Homem Aranha - De Volta ao Lar", "Aventura", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Capitão América Guerra Civil", "Aventura/Ficção", "2017");
        listaFilmes.add(filme);

        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Pica-Pau: O Filme", "Comedia/Animação", "2017");
        listaFilmes.add(filme);

        filme = new Filme("A Múmia", "Terror", "2017");
        listaFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Meu Malvado Favorito 3", "Comédia", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Carros 3", "Animação", "2017");
        listaFilmes.add(filme);
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
 *       fixador de visualização. Ou seja, nesse método tem também uma ViewHolder que está associada com o ViewHolder da
 *       onCreateViewHolder.
 *
 *   -> getItemCount(): a RecyclerView chama esse método para ver o tamanho do conjunto de dados. Por exemplo, em um app
 *      de lista de endereços, pode ser o número total de endereços. O RecyclerView usa essa função para determinar quando
 *      não há mais itens a serem exibidos.
 *
 *  ------------------------------------------------
 *  Vamos fazer o reuso de uma Classe que é padrão do Google para eventos de click.
 *
 * No Android, há mais de uma maneira de interceptar os eventos da interação de um usuário com o app. Ao considerar os eventos dentro
 * da interface do usuário, a abordagem é capturar os eventos de um objeto View específico com que o usuário interage. A classe
 * View fornece os meios para fazer isso.
 *
 * Dentro das várias classes View que você usará para compor o layout, é possível notar vários métodos públicos de callback que
 * parecem úteis para eventos de IU. Esses métodos são chamados pelo framework do Android quando a ação em questão ocorre nesse
 * objeto. Por exemplo, quando uma View (como um botão) é tocada, o método onTouchEvent() é chamado neste objeto. No entanto, para
 * interceptar esse evento, você precisa estender a classe e substituir o método. Além disso, estender todos os objetos View para
 * lidar com tal evento não seria algo prático. É por isso que a classe View também contém uma coleção de interfaces aninhadas com
 * callbacks que podem ser definidas com muito mais facilidade. Essas interfaces, chamadas de listeners de eventos, são a forma de
 * capturar a interação do usuário com a IU.
 *
 * Geralmente, os listeners de eventos são usados para detectar a interação do usuário. No entanto, pode haver casos em que você
 * queira estender uma classe View para criar um componente personalizado. Talvez você queira estender a classe Button para deixar
 * algo mais sofisticado. Neste caso, você poderá definir os comportamentos de eventos padrão para a classe usando manipuladores de
 * eventos.
 *
 * Listeners de eventos
 * Um listener de eventos é uma interface na classe View que contém um único método de callback. Esses métodos serão chamados pelo
 * framework do Android quando a View a que o listener estiver registrado for ativada pela interação do usuário com o item na IU.
 * Os seguintes métodos de callback estão incluídos nas interfaces do listener de eventos:
 *
 * onClick()
 * De View.OnClickListener. É chamado quando o usuário toca no item (no modo de toque) ou foca no item com as teclas de navegação ou
 * o trackball e pressiona a tecla "Enter" adequada ou pressiona o trackball.
 *
 * onLongClick()
 * De View.OnLongClickListener. É chamado quando o usuário mantém o item pressionado (no modo de toque) ou foca no item com as teclas
 * de navegação ou o trackball e mantém pressionada a tecla "Enter" adequada ou mantém o trackball pressionado (por um segundo).
 *
 * onFocusChange()
 * De View.OnFocusChangeListener. É chamado quando o usuário navega para ou do item usando as teclas de navegação ou o trackball.
 *
 * onKey()
 * De View.OnKeyListener. É chamado quando o usuário está com foco no item e pressiona ou solta uma tecla de hardware no dispositivo.
 *
 * onTouch()
 * De View.OnTouchListener. É chamado quando o usuário realiza uma ação qualificada como um evento de toque, incluindo o pressionamento, a liberação ou qualquer outro gesto de movimento na tela (dentro dos limites do item).
 *
 * onCreateContextMenu()
 * De View.OnCreateContextMenuListener. É chamado quando um menu de contexto está sendo criado (como resultado de um "clique longo"). Consulte a discussão sobre menus de contexto no guia do desenvolvedor de Menus.
 *
 **/