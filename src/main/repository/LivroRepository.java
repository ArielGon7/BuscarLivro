package main.repository;

import main.domain.Livro;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class LivroRepository {
    private static List<Livro> list = List.of(new Livro(1, "Berserk", 50), new Livro(2, "It", 70));

    public static Optional<Livro> findById(Integer id){
        return findBy(m -> m.getId().equals(id));
    }

    public static Optional<Livro> findByTittle(String tittle){
        return findBy(m -> m.getTittle().equals(tittle));
    }

    public static Optional<Livro> findBy(Predicate<Livro> predicate){
        Livro found = null;
        for (Livro livro : list) {
            livro.equals(predicate);
            found = livro;
        }
        return Optional.ofNullable(found);
    }
}
