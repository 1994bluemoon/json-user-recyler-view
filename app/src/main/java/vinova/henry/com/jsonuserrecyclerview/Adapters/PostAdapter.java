package vinova.henry.com.jsonuserrecyclerview.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vinova.henry.com.jsonuserrecyclerview.Models.Post;
import vinova.henry.com.jsonuserrecyclerview.R;

/**
 * Created by dminh on 1/29/2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<Post> posts;
    Context mContext;

    public PostAdapter(List<Post> posts, Context mContext) {
        this.posts = posts;
        this.mContext = mContext;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Context getmContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_items, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvWords.setText(posts.get(position).getWords());
        holder.tvParagraph.setText(posts.get(position).getParagraph());
    }

    @Override
    public int getItemCount() {
        return posts == null ? 0 : posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.tv_words)
        TextView tvWords;
        @BindView(R.id.tv_paragraph)
        TextView tvParagraph;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
