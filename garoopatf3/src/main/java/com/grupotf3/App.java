package com.grupotf3;

import com.grupotf3.Entidades.CategoriaVeiculo;
import com.grupotf3.Entidades.FactoryVeiculo;
import com.grupotf3.Entidades.*;

public class App 
{
    public static void main( String[] args )
    {
        Veiculo v = FactoryVeiculo.criaVeiculo("1234", "Ford", "Verde", CategoriaVeiculo.LUXO);

        System.out.println(v);
    }
}
