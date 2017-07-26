package jp.deltaworks.games.elements;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainGame extends ApplicationAdapter {
//    SpriteBatch batch;
//    Texture img;
//    private static final int VIEWPORT_WIDTH = 1080;
//    private static final int VIEWPORT_HEIGHT = 1920;
//    private static final int WORLD_WIDTH = 1080;
//    private static final int WORLD_HEIGHT = 1920;
    private static final int VIEWPORT_WIDTH = 720;
    private static final int VIEWPORT_HEIGHT = 1280;
    private static final int WORLD_WIDTH = 720;
    private static final int WORLD_HEIGHT = 1280;

//    private OrthographicCamera camera;
    private Viewport viewport;

    private Stage stage;

    @Override
    public void create () {
//        batch = new SpriteBatch();
//        img = new Texture("badlogic.jpg");

        OrthographicCamera camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        stage = new Stage(viewport);

        Texture texture = new Texture("elements/star.png");
        for (int i = 0; i < 7; i++) {
            Image image = new Image(texture);
            int posY = i % 2 != 0 ? 50 : 0;
            image.setPosition(100 * i, posY);
            stage.addActor(image);
        }

    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        batch.begin();
//        batch.draw(img, 0, 0);
//        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose () {
//        batch.dispose();
//        img.dispose();
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height);
    }
}
