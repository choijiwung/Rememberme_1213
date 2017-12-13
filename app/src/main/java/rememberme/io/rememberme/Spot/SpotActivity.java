package rememberme.io.rememberme.Spot;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import rememberme.io.rememberme.R;

import static rememberme.io.rememberme.R.id.txtFirstLastName;

public class SpotActivity extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot);
        listView = (ListView) findViewById(R.id.listView);

        final ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String, Object>>();

        HashMap<String,Object> map1 = new HashMap<String,Object>();
        map1.put("Image",R.drawable.trip1_rome);
        map1.put("FirstLastName", "로마 콜로세움");
        map1.put("Descriptions","내 이름은 막시무스!");
        map1.put("Params1","1일차");

        list.add(map1);

        HashMap<String,Object> map2 = new HashMap<String,Object>();
        map2.put("Image",R.drawable.trip2_firenze);
        map2.put("FirstLastName","피렌체  성당");
        map2.put("Descriptions","성스러운 기운이 느껴진다.....");
        map2.put("Params1","2일차");

        list.add(map2);

        HashMap<String,Object> map3 = new HashMap<String,Object>();
        map3.put("Image",R.drawable.trip3_venis);
        map3.put("FirstLastName","베니스강");
        map3.put("Descriptions","베니스강을 너와 함께 걷고 싶다.");
        map3.put("Params1","3일차");
        list.add(map3);

        adapter = new CustomAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpotActivity.this,list.get(position).get("FirstLastName").toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    class CustomAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<HashMap<String,Object>> data;

        public CustomAdapter(Context context,ArrayList<HashMap<String,Object>> data){
            this.context = context;
            this.data = data;
        }

        @Override
        public int getCount(){
            return data.size();
        }

        @Override
        public Object getItem(int position){
            return data.get(position);
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ViewHolder holder;
            if(convertView == null){
                holder =new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
                holder.imgIcon = (ImageView)convertView.findViewById(R.id.imgIcon);
                holder.txtFirstLastName = (TextView)convertView.findViewById(txtFirstLastName);
                holder.txtDescription = (TextView)convertView.findViewById(R.id.txtDescription);
                holder.txtParams1 = (TextView)convertView.findViewById(R.id.txtParams1);

                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }

            holder.imgIcon.setImageResource((Integer) data.get(position).get("Image"));
            holder.txtFirstLastName.setText(data.get(position).get("FirstLastName").toString());
            holder.txtDescription.setText(data.get(position).get("Descriptions").toString());
            holder.txtParams1.setText(data.get(position).get("Params1").toString());



            return convertView;
        }

        class ViewHolder{
            ImageView imgIcon;
            TextView txtFirstLastName;
            TextView txtDescription;
            TextView txtParams1;

        }
    }

}
