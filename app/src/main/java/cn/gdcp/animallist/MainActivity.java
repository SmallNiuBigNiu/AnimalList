package cn.gdcp.animallist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Animal> animalList=new ArrayList<Animal>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initAnimlData();
        ListView listView=(ListView)findViewById(R.id.listview);
        AnimlaAdater animlaAdater=new AnimlaAdater(getApplication(),R.layout.animal,animalList);
        listView.setAdapter(animlaAdater);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal animal=animalList.get(i);
                Toast.makeText(getApplication(),animal.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void initAnimlData(){
        for (int i=0;i<2;i++){
            Animal animal1=new Animal("皮卡丘",R.drawable.dog5);
            animalList.add(animal1);
            Animal animal2=new Animal("皮卡丘",R.drawable.dog5);
            animalList.add(animal2);
            Animal animal3=new Animal("皮卡丘",R.drawable.dog5);
            animalList.add(animal3);
            Animal animal4=new Animal("皮卡丘",R.drawable.dog5);
            animalList.add(animal4);
            Animal animal5=new Animal("皮卡丘",R.drawable.dog5);
            animalList.add(animal5);
            Animal animal6=new Animal("皮卡丘",R.drawable.dog5);
            animalList.add(animal6);
            Animal animal7=new Animal("皮卡丘",R.drawable.dog5);
            animalList.add(animal7);
        }
    }
    public class AnimlaAdater extends ArrayAdapter<Animal>{


        public AnimlaAdater(Context context, int resource, List<Animal> objects) {
            super(context, resource, objects);
        }

        @Override
        public int getCount() {
            return animalList.size();
        }

        @Override
        public Animal getItem(int i) {
            return animalList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convetView, ViewGroup viewGroup) {
            //获取动物实例类
            Animal animal=getItem(i);
            View view;
            //如果视图为空，创建视图
            if(convetView==null){
                view= LayoutInflater.from(getApplication()).inflate(R.layout.animal,null);
            }else {
                view=convetView;
            }
            //获取view中的数据，一定要从view里面获取
            ImageView animalImage=(ImageView)view.findViewById(R.id.animal_img);
            TextView animalText=(TextView)view.findViewById(R.id.animal_tv);
            //传入数据
            animalImage.setImageResource(animal.getAnimalId());
            animalText.setText(animal.getName());
            return view;
        }
    }
}
