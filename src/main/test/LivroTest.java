package main.test;

import main.domain.Livro;
import main.repository.LivroRepository;

import java.util.Optional;

public class LivroTest {
    public static void main(String[] args) throws IllegalAccessException {

        Optional<Livro> livroByTittle = LivroRepository.findByTittle("Berserk");
        livroByTittle.ifPresent(m -> m.setTittle("Berserk: new edition"));
        System.out.println(livroByTittle);

        System.out.println("-------------");

        Livro byId = LivroRepository.findById(2).orElseThrow(IllegalAccessError::new);
        System.out.println(byId);

        System.out.println("-------------");


        Optional<Livro> findByNewTittle = Optional.of(LivroRepository.findByTittle("Biblia").orElseGet(() -> new Livro(3, "Biblia", 1189)));
        System.out.println(findByNewTittle);

    }
}
