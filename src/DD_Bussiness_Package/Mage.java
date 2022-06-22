package DD_Bussiness_Package;

public class Mage extends Player{
    protected Mana mana;
    protected int mana_cost;
    protected int spell_power;
    protected int hits_count;
    protected int ability_range;

    public Mage(int x, int y, String name, int h_p, int attack_points, int defense_points, int mana_pool, int mana_cost, int spell_power, int hits_count, int ability_range) {
        super(new Coordinate(x, y), name, new Health(h_p, h_p), attack_points, defense_points);
        this.mana = new Mana(mana_pool, mana_pool / 4);
        this.mana_cost = mana_cost;
        this.spell_power = spell_power;
        this.hits_count = hits_count;
        this.ability_range = ability_range;
    }

    public void Level_Up(){
        super.Level_Up();
        ////////////////////////////  now addons  ////////////////////////////  /////  add print here or somewhere else
        this.mana.setMana_pool(this.mana.getMana_pool() + (25*this.getPlayer_Level()));
        this.mana.setCurrent_mana(Math.min(this.mana.getCurrent_mana() + (this.mana.getMana_pool()/4), this.mana.getMana_pool()));
        this.spell_power = this.spell_power + (10*this.getPlayer_Level());

        int hea_add = (10*this.getPlayer_Level()), att_add = (4*this.getPlayer_Level()), def_add = (this.getPlayer_Level()), mana_add = (25*this.getPlayer_Level()), spe_add = (10*this.getPlayer_Level());  ///////  now change them accordingly
        String message = "\n" + this.getName() + " reached level " + this.getPlayer_Level() + ": +" + hea_add + " Health, +" + att_add + " Attack, +" + def_add + " Defense, +" + mana_add + " Maximum mana, +" + spe_add + " Spell power." + "\n";
        this.getMessageCallback().send(message);  /////////////////  the message with the regular upgrades + the class upgrades !!!
    }

    @Override
    public void Ability_Cast(Game_Board game_board) {
        if(this.mana.getCurrent_mana() < this.mana_cost){
            this.getMessageCallback().send("You don't have enough Mana in order to use your ability");
        }else{
            this.mana.setCurrent_mana(this.mana.getCurrent_mana() - this.mana_cost);
            int hits = 0;
//            while(hits < this.hits_count && ){   /////////////////////////////////////////  continue
//                //////////// continue casting the ability
//                hits += 1;
//            }
        }
    }

    @Override
    public void On_Tick_Do(Game_Board game) {
        this.mana.setCurrent_mana(Math.min(this.mana.getMana_pool(), this.mana.getCurrent_mana() + this.getPlayer_Level()));
    }

    @Override
    public String description() {      /////////   returns full information of the current unit, maybe just .send(what we return here), maybe...
        return super.description() + "        Mana: " + this.mana.getCurrent_mana() + "/" + this.mana.getMana_pool() + "        Spell Power: " + this.spell_power + "\n";
    }

}