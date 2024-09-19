package com.example.dolcecapsulas.presenter.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dolcecapsulas.data.model.Capsula

class HomeViewModel : ViewModel() {

    private val _capsulasList = MutableLiveData<List<Capsula>>()
    val capsulasList: LiveData<List<Capsula>> get() = _capsulasList

    init {
        loadMockCapsulas()
    }

    private fun loadMockCapsulas() {
        // Criando uma lista de cápsulas mock
        val mockList = listOf(
            Capsula("1", "Café Espresso", "Um café expresso de sabor intenso e encorpado, com uma crema espessa e persistente. Ideal para quem aprecia um café forte e energizante, com notas profundas e um final aveludado."),
            Capsula("2", "Café Latte", "Um café latte suave e cremoso, feito com uma rica mistura de café expresso e leite vaporizado. Perfeito para uma pausa relaxante, com um sabor equilibrado e uma textura sedosa que derrete na boca."),
            Capsula("3", "Chá de Camomila", "Um chá de camomila aromático e reconfortante, ideal para momentos de tranquilidade. Com um sabor delicado e floral, proporciona uma sensação de calma e bem-estar, perfeito para ser apreciado antes de dormir."),
            Capsula("4", "Café Americano", "Um café americano suave e levemente diluído, feito com uma dose de café expresso e água quente. Oferece um sabor encorpado, mas mais leve do que um expresso puro, ideal para um café longo e relaxante."),
            Capsula("5", "Cappuccino", "Um cappuccino clássico com a combinação perfeita de café expresso, leite vaporizado e espuma de leite. O sabor forte do café é suavizado pela textura cremosa do leite, criando uma bebida equilibrada e reconfortante."),
            Capsula("6", "Chá Preto com Limão", "Um chá preto robusto com um toque refrescante de limão. O sabor encorpado do chá preto é equilibrado com a acidez do limão, resultando em uma bebida revigorante e cheia de sabor."),
            Capsula("7", "Café Mocha", "Uma mistura deliciosa de café expresso e chocolate, coberta com uma camada de espuma de leite. O café mocha combina o sabor intenso do café com a doçura do chocolate, criando uma bebida indulgente e prazerosa."),
            Capsula("8", "Chá Verde", "Um chá verde suave e refrescante, conhecido por suas propriedades antioxidantes. Com um sabor ligeiramente adocicado e notas vegetais, é uma escolha saudável e revitalizante para qualquer momento do dia."),
            Capsula("9", "Café Caramel Macchiato", "Um café expresso rico e suave com um toque de baunilha, coberto com uma camada de espuma de leite e um fio de caramelo. A combinação de café e caramelo cria uma bebida doce e satisfatória."),
            Capsula("10", "Café Ristretto", "Um café ristretto é um expresso mais concentrado e intenso, com um sabor mais profundo e uma crema mais espessa. Ideal para os amantes de café que buscam uma experiência mais robusta e encorpada.")
        )
        _capsulasList.value = mockList
    }
}