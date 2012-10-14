/*
package electricexpansion.client.alex_hawks;

import org.lwjgl.opengl.GL11;

import electricexpansion.EECommonProxy;
import electricexpansion.ElectricExpansion;
import electricexpansion.alex_hawks.cables.TileEntityInsulatedWire;
import electricexpansion.alex_hawks.cables.TileEntitySwitchWire;
import electricexpansion.alex_hawks.cables.TileEntitySwitchWireOff;
import electricexpansion.api.CableConnectionInterfaces.IPanelElectricMachine;
import net.minecraft.src.Block;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;
import net.minecraftforge.common.ForgeDirection;

public class RenderInsulatedWire extends TileEntitySpecialRenderer 
{
	private ModelInsulatedWire model;

	public RenderInsulatedWire()
	{
		model = new ModelInsulatedWire();
	}
	public void renderAModelAt(TileEntity tileEntity, double x, double y, double z, float f)
	{
		String textureToUse = null;
		int ID = tileEntity.getBlockType().blockID;
		int meta = tileEntity.getBlockMetadata();
		if(meta != -1)
		{
			if(ID == ElectricExpansion.insulatedWire)
			{
				if(meta == 0)
					textureToUse = EECommonProxy.ATEXTURES + "CopperWire.png";
				else if(meta == 1)
					textureToUse = EECommonProxy.ATEXTURES + "InsulatedTinWire.png";
				else if(meta == 2)
					textureToUse = EECommonProxy.ATEXTURES + "InsulatedSilverWire.png";
				else if(meta == 3)
					textureToUse = EECommonProxy.ATEXTURES + "InsulatedHVWire.png";
			}
			else if(ID == ElectricExpansion.onSwitchWire)
			{
				if(meta == 0)
					textureToUse = EECommonProxy.ATEXTURES + "CopperSwitchWireOn.png";
				else if(meta == 1)
					textureToUse = EECommonProxy.ATEXTURES + "TinSwitchWireOn.png";
				else if(meta == 2)
					textureToUse = EECommonProxy.ATEXTURES + "SilverSwitchWireOn.png";
				else if(meta == 3)
					textureToUse = EECommonProxy.ATEXTURES + "HVSwitchWireOn.png";
			}	
			else if(ID == ElectricExpansion.offSwitchWire)
			{
				if(meta == 0)
					textureToUse = EECommonProxy.ATEXTURES + "CopperSwitchWireOff.png";
				else if(meta == 1)
					textureToUse = EECommonProxy.ATEXTURES + "TinSwitchWireOff.png";
				else if(meta == 2)
					textureToUse = EECommonProxy.ATEXTURES + "SilverSwitchWireOff.png";
				else if(meta == 3)
					textureToUse = EECommonProxy.ATEXTURES + "HVSwitchWireOff.png";
			}	
		}

		//Texture file
		bindTextureByName(textureToUse);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);

		if (tileEntity instanceof TileEntityInsulatedWire)
		{
			TileEntityInsulatedWire TE = (TileEntityInsulatedWire)tileEntity;
			Block[] neighbors = new Block[6];
			for(int i=0; i<6; i++)
				if(TE.connectedBlocks[i] != null)
					neighbors[i] = TE.connectedBlocks[i].getBlockType();
			int[] metaConnected = new int[6];
			for(int i=0; i<6; i++)
				metaConnected[i] = TE.connectedBlocks[i].blockMetadata;
			
			for(int i=0; i<6; i++)
				if (TE.connectedBlocks[i] != null)
					if (neighbors[i] instanceof IPanelElectricMachine)
						model.renderBottom();
			
			if (TE.connectedBlocks[0] != null) {model.renderBottom();}
			if (TE.connectedBlocks[1] != null) {model.renderTop();}
			if (TE.connectedBlocks[2] != null) 
			{
				if (neighbors[2] instanceof IPanelElectricMachine)
					if(((IPanelElectricMachine)TE.connectedBlocks[2]).canConnectToBase(metaConnected[2], ForgeDirection.getOrientation(3)))
						model.renderPanelBack();
				else model.renderBack();
			}
			if (TE.connectedBlocks[3] != null) 
			{
				if (neighbors[3] instanceof IPanelElectricMachine)
					if(((IPanelElectricMachine)TE.connectedBlocks[3]).canConnectToBase(metaConnected[3], ForgeDirection.getOrientation(2)))
						model.renderPanelFront();
				else model.renderFront();
			}
			if (TE.connectedBlocks[4] != null) 
			{
				if (neighbors[4] instanceof IPanelElectricMachine)
					if(((IPanelElectricMachine)TE.connectedBlocks[4]).canConnectToBase(metaConnected[4], ForgeDirection.getOrientation(5)))
						model.renderPanelLeft();
				else model.renderLeft();
			}
			if (TE.connectedBlocks[5] != null) 
			{
				if (neighbors[5] instanceof IPanelElectricMachine)
					if(((IPanelElectricMachine)TE.connectedBlocks[5]).canConnectToBase(metaConnected[5], ForgeDirection.getOrientation(4)))
						model.renderPanelRight();
				else model.renderRight();
			}
		}

		else if (tileEntity instanceof TileEntitySwitchWire)
		{
			TileEntitySwitchWire TE = (TileEntitySwitchWire)tileEntity;
			Block[] neighbors = new Block[6];
			for(int i=0; i<6; i++)
				if(TE.connectedBlocks[i] != null)
					neighbors[i] = TE.connectedBlocks[i].getBlockType();
			int[] metaConnected = new int[6];
			for(int i=0; i<6; i++)
				if(TE.connectedBlocks[i] != null)
					metaConnected[i] = TE.connectedBlocks[i].blockMetadata;
			
			for(int i=0; i<6; i++)
				if (TE.connectedBlocks[i] != null)
					if (neighbors[i] instanceof IPanelElectricMachine)
						model.renderBottom();
			
			if (TE.connectedBlocks[0] != null) {model.renderBottom();}
			if (TE.connectedBlocks[1] != null) {model.renderTop();}
			if (TE.connectedBlocks[2] != null) 
			{
				if (neighbors[2] instanceof IPanelElectricMachine)
					if(((IPanelElectricMachine)TE.connectedBlocks[2]).canConnectToBase(metaConnected[2], ForgeDirection.getOrientation(3)))
						model.renderPanelBack();
				else model.renderBack();
			}
			if (TE.connectedBlocks[3] != null) 
			{
				if (neighbors[3] instanceof IPanelElectricMachine)
					if(((IPanelElectricMachine)TE.connectedBlocks[3]).canConnectToBase(metaConnected[3], ForgeDirection.getOrientation(2)))
						model.renderPanelFront();
				else model.renderFront();
			}
			if (TE.connectedBlocks[4] != null) 
			{
				if (neighbors[4] instanceof IPanelElectricMachine)
					if(((IPanelElectricMachine)TE.connectedBlocks[4]).canConnectToBase(metaConnected[4], ForgeDirection.getOrientation(5)))
						model.renderPanelLeft();
				else model.renderLeft();
			}
			if (TE.connectedBlocks[5] != null) 
			{
				if (neighbors[5] instanceof IPanelElectricMachine)
					if(((IPanelElectricMachine)TE.connectedBlocks[5]).canConnectToBase(metaConnected[5], ForgeDirection.getOrientation(4)))
						model.renderPanelRight();
				else model.renderRight();
			}
		}

		else if (tileEntity instanceof TileEntitySwitchWireOff)
		{
			//model.renderNothing();
		}
		model.renderMiddle();
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2, double var4, double var6, float var8)
	{
		this.renderAModelAt(tileEntity, var2, var4, var6, var8);
	}
}
*/
