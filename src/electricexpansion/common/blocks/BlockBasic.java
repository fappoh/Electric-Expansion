package electricexpansion.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricexpansion.common.ElectricExpansion;
import electricexpansion.common.misc.EETab;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockBasic extends Block
{
	public BlockBasic(int id, Material material, CreativeTabs tab, float hardness, 
			float resistance, String name, float lightValue, StepSound sound)
	{
		super(id, material);
		this.setCreativeTab(tab);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setUnlocalizedName(name);
		this.setStepSound(sound);
		this.setLightValue(lightValue);
	}
	
	public BlockBasic(int id, Material material, CreativeTabs tab, float hardness, 
			float resistance, String name, float lightValue)
	{
		this(id, material, tab, hardness, resistance, name, lightValue, soundMetalFootstep);
	}
	
	public BlockBasic(int id, Material material, CreativeTabs tab, float hardness, 
			float resistance, String name)
	{
		this(id, material, tab, hardness, resistance, name, 0F, soundMetalFootstep);
	}

	public BlockBasic(int id, Material material, CreativeTabs tab, float hardness, String name)
	{
		this(id, material, tab, hardness, 1F, name, 0F, soundMetalFootstep);
	}

	public BlockBasic(int id, CreativeTabs tab, float hardness, float resistance, String name)
	{
		this(id, Material.iron, tab, hardness, resistance, name, 0F, soundMetalFootstep);
	}

	public BlockBasic(int id, CreativeTabs tab, float hardness, String name)
	{
		this(id, Material.iron, tab, hardness, 1F, name, 0F, soundMetalFootstep);
	}

	public BlockBasic(int id, CreativeTabs tab, String name)
	{
		this(id, Material.iron, tab, 1F, 1F, name, 0F, soundMetalFootstep);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister par1IconRegister)
    {
        this.field_94336_cN = par1IconRegister.func_94245_a(this.getUnlocalizedName().replace("tile.", ElectricExpansion.TEXTURE_NAME_PREFIX));
    }

}
