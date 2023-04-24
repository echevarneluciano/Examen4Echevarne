package com.example.examen4echevarne;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examen4echevarne.modelo.Nota;

import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Nota>> lista;
    private ArrayList<Nota> Notas ;

    public MainActivityViewModel() {
        Notas = new ArrayList<>();
    }

    public LiveData<ArrayList<Nota>> getLista() {
        if(this.lista == null){
            this.lista = new MutableLiveData<>();
        }
        return this.lista;
    }

    public void llenarLista(){
        Notas.clear();
        Notas.add(new Nota("Estudiar", "Estudiar moviles", "Alta", "10-10-2020"));
        Notas.add(new Nota("Rendir", "Rendir moviles", "Alta", "11-11-2023"));
        Notas.add(new Nota("Dormir","Dormir la ciesta", "Media", "12-12-2024"));
        lista.setValue(Notas);
    }
}

