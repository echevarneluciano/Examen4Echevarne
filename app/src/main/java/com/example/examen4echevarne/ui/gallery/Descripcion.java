package com.example.examen4echevarne.ui.gallery;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.examen4echevarne.MainActivity;
import com.example.examen4echevarne.R;
import com.example.examen4echevarne.databinding.FragmentDescripcionBinding;
import com.example.examen4echevarne.modelo.Nota;

public class Descripcion extends Fragment {

    private DescripcionViewModel mViewModel;
    private FragmentDescripcionBinding binding;
    private int index;

    public static Descripcion newInstance() {
        return new Descripcion();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {DescripcionViewModel descripcionViewModel =
            new ViewModelProvider(this).get(DescripcionViewModel.class);

        binding = FragmentDescripcionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        DescripcionViewModel dv =
                new ViewModelProvider(this).get(DescripcionViewModel.class);

        dv.getIndex().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.d("salida", "borrada: "+integer);
                Toast.makeText(getContext(),"Nota N° "+(index+1)+" eliminada", Toast.LENGTH_LONG).show();
            }
        });

        dv.getNota().observe(getViewLifecycleOwner(), new Observer<Nota>() {
            @Override
            public void onChanged(Nota a) {
                binding.tvDescripcion.setText(a.getDescripcion()+"");
                binding.tvPrioridad.setText(a.getPrioridad()+"");
                binding.tvFecha.setText(a.getFecha()+"");
                binding.tvTiulo.setText(a.getTitulo()+"");
            }
        });

        if(getArguments()!=null){
            Nota a = (Nota) getArguments().getSerializable("notas");
            index = (int) getArguments().getSerializable("index");
            dv.llenarNota(a);
        }

        binding.btEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dv.borrarNota(index);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DescripcionViewModel.class);
        // TODO: Use the ViewModel
    }

}