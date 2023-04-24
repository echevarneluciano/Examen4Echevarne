package com.example.examen4echevarne.ui.gallery;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examen4echevarne.MainActivity;
import com.example.examen4echevarne.modelo.Nota;

import java.util.ArrayList;
import java.util.Date;

public class DescripcionViewModel extends ViewModel {
    private MutableLiveData<Nota> lista;
    private MutableLiveData<Integer> index;
    private Nota nota ;

    public DescripcionViewModel() {
    }

    public LiveData<Nota> getNota() {
        if(this.lista == null){
            this.lista = new MutableLiveData<>();
        }
        return this.lista;
    }

    public LiveData<Integer> getIndex() {
        if(this.index == null){
            this.index = new MutableLiveData<>();
        }
        return this.index;
    }

    public void llenarNota(Nota nota){
        lista.setValue(nota);
    }

    public void borrarNota(int index){
        this.index.setValue(index);
        MainActivity.notas.remove(index);
    }

}
