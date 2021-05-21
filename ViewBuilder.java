package Fi06.candles;

import android.content.res.Resources;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class ViewBuilder {

    private ArrayList<Material> materials;

    void buildSpinner(MainActivity mainActivity) {
        setMaterialNames(mainActivity.getResources());
        populateList();
        setSpinnerAdapter(mainActivity);
    }

    private void setSpinnerAdapter(MainActivity mainActivity) {
        Spinner spinner = (Spinner) mainActivity.findViewById(R.id.candleSpinner);
        ArrayAdapter<Material> adapter = new ArrayAdapter<>(mainActivity.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, materials);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void populateList() {
        materials = new ArrayList<>();

        materials.addAll(Arrays.asList(Material.values()));
    }

    private void setMaterialNames(Resources resources) {
        Material.PARAFIN.setName(resources.getString(R.string.paraffin));
        Material.STEARIN.setName(resources.getString(R.string.stearin));
        Material.BEEWAX.setName(resources.getString(R.string.beewax));
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }
}
