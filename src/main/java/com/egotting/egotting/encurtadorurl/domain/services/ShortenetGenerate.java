package com.egotting.egotting.encurtadorurl.domain.services;

import com.egotting.egotting.encurtadorurl.domain.services.Interface.IShortenerGenerate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ShortenetGenerate implements IShortenerGenerate {
    @Override
    public String generate() {
        Random random = new Random();
        int tamanho = 10;
        String c = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            int indice_random = random.nextInt(c.length());
            char random_caractere = c.charAt(indice_random);
            sb.append(random_caractere);
        }
        return sb.toString();
    }
}
