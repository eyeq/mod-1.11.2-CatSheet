package eyeq.catsheet;

import eyeq.util.client.renderer.ResourceLocationFactory;
import eyeq.util.client.resource.ULanguageCreator;
import eyeq.util.client.resource.lang.LanguageResourceManager;
import eyeq.util.oredict.UOreDictionary;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.SoundType;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import eyeq.catsheet.event.CatSheetEventHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.io.File;

import static eyeq.catsheet.CatSheet.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
@Mod.EventBusSubscriber
public class CatSheet {
    public static final String MOD_ID = "eyeq_catsheet";

    @Mod.Instance(MOD_ID)
    public static CatSheet instance;

    private static final ResourceLocationFactory resource = new ResourceLocationFactory(MOD_ID);

    public static Block catSheet;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new CatSheetEventHandler());
        addRecipes();
        if(event.getSide().isServer()) {
            return;
        }
        renderItemModels();
        createFiles();
    }

    @SubscribeEvent
    protected static void registerBlocks(RegistryEvent.Register<Block> event) {
        catSheet = new BlockCarpet() {{setSoundType(SoundType.CLOTH);}}.setHardness(0.1F).setLightOpacity(0).setUnlocalizedName("catSheet");

        GameRegistry.register(catSheet, resource.createResourceLocation("cat_sheet"));
    }

    @SubscribeEvent
    protected static void registerItems(RegistryEvent.Register<Item> event) {
        GameRegistry.register(new ItemCloth(catSheet), catSheet.getRegistryName());
    }

    public static void addRecipes() {
        for(EnumDyeColor color : EnumDyeColor.values()) {
            int meta = color.getMetadata();
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(catSheet, 4, meta), "XXY",
                    'X', new ItemStack(Blocks.WOOL, 1, meta), 'Y', UOreDictionary.OREDICT_STRING));
        }
    }

    @SideOnly(Side.CLIENT)
    public static void renderItemModels() {
        Item item = Item.getItemFromBlock(catSheet);
        for(EnumDyeColor color : EnumDyeColor.values()) {
            int meta = color.getMetadata();
            ModelLoader.setCustomModelResourceLocation(item, meta, resource.createModelResourceLocation(color.getName() + "_cat_sheet"));
        }
    }

    public static void createFiles() {
        File project = new File("../1.11.2-CatSheet");

        LanguageResourceManager language = new LanguageResourceManager();

        language.register(LanguageResourceManager.EN_US, "tile.catSheet.black.name", "Black Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.black.name", "黒色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.red.name", "Red Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.red.name", "赤色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.green.name", "Green Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.green.name", "緑色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.brown.name", "Brown Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.brown.name", "茶色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.blue.name", "Blue Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.blue.name", "青色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.purple.name", "Purple Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.purple.name", "紫色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.cyan.name", "Cyan Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.cyan.name", "水色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.silver.name", "Silver Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.silver.name", "薄灰色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.gray.name", "Gray Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.gray.name", "灰色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.pink.name", "Pink Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.pink.name", "桃色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.lime.name", "Lime Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.lime.name", "黄緑色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.yellow.name", "Yellow Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.yellow.name", "黄色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.lightBlue.name", "Light Blue Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.lightBlue.name", "空色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.magenta.name", "Magenta Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.magenta.name", "赤紫色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.orange.name", "Orange Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.orange.name", "橙色のねこ用マッド");
        language.register(LanguageResourceManager.EN_US, "tile.catSheet.white.name", "White Cat Sheet");
        language.register(LanguageResourceManager.JA_JP, "tile.catSheet.white.name", "白色のねこ用マッド");

        ULanguageCreator.createLanguage(project, MOD_ID, language);
    }
}
