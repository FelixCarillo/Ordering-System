public class Inventory {
    public static Eyeglass[] getEyeglasses() {
        Eyeglass[] eyeglasses = {
            new Eyeglass(1, "EO Eyestyle Eyest2505", "Stainless Steel and Acetate", 999.00, "Browline, square", "Black, Black and Gold, Crystal Black, Crystal Brown"),
            new Eyeglass(2, "EO Young", "Stainless Steel", 2580.00,"Aviator","Black, Copper, Gold, Grey, Matt Rose Gold, and Toffee"),
            new Eyeglass(3, "EO Woo-Wide", "Stainless Steal", 2580.00, "Rectangle", "Black, Burgundy, Chery Blossom, Crimson, Grey, Lavander, anti-glare, and UV protection"),
            new Eyeglass(4, "EO Eyeweak Kyle", "Stainless Steel", 2580.00, "Aviator, full rim", "Antique Gun, S. Gold, S. Brown, Matt Brown"),
            new Eyeglass(5, "EO Eyewear Sullivan", "Stainless Steal", 2580.00, "Round", "M.Black/S.Gun, M.Solid Brown/S.R.Gold, M.Brown/S.L.Brown, M.L.Grey/S.J.Gold, and M.S.Beige/S.R.Gold"),
            new Eyeglass(6, "EO Eyewear Elvis", "TR90 and B-titanium", 2580.00, "Full rim rectangle", "Barn"),
            new Eyeglass(7, "EO Eyewear Donovan Clip-On", "Metal", 2980.00, "Full rim square", "Pink"),
            new Eyeglass(8, "EO Eyewear Alexandra", "Acetate", 2580.00, "Full rim square", "Crstal med grey"),
            new Eyeglass(9, "EO Eyewear Breakthrough-Wider", "Metal", 2580.00, "Full rim rectangle", "Matt silver and copper"),
            new Eyeglass(10, "EO Zack", "Metal", 2580.00, "Aviator/Pilot", "M.Gun/M.Silver"),
            new Eyeglass(11, "EO Neil", "Stainless steel", 2580.00, "Full rim rectangle", "Matt Gun, S.Gun, S.Brown, and S.Gun/Purple"),
            new Eyeglass(12, "EO Eyestyle eyest2506", "Stainless Steal and Acetate", 999.00, "Browline, square", "Black, Black and Gold, Crystal Black, Crystal Brown"),
            new Eyeglass(13, "EO Eyestyle eyest2504", "Stainless steel and Acetate", 999.00, "Browline, square", "Black, Black and Gold, Black and Silver, Crystal Black, Crystal Brown"),
            new Eyeglass(14, "EO Eyewear Galatia", "TR90", 2580.00, "Square", "M.Solid Blue/M.T.L Green, M.Clear and S.Black/S.T.Green"),
            new Eyeglass(15, "EO Eyestyle eyest2503", "stainless steel and Acetate", 999.00, "Browline, sqaure", "Black, Black and Gold, Crystal Black, Crystal Brown"),
            new Eyeglass(16, "EO Eyewear Carrie", "Stainless steel", 2580.00, "Round", "S. Olive, S.Gun/Purple"),
        };
        return eyeglasses;

    public static AddOn[] getAddOns() {
        AddOn[] addOns = {
            new AddOn(1,"Anti-glare coating",1000.0 ),
            new AddOn(2,"Blue Light Filter",1900.0 ),
            new AddOn(3,"Photochromic Lenses",2000.0 ),
            new AddOn(4,"Scratch-resistant coating",300.0 ),
            new AddOn(5,"High-index lenses",3000.0 ),
            new AddOn(6,"Polarized glasses",2500.0 ),
            new AddOn(7,"UV Protection",300.0 ),
        };
        return addOns;
    }
    
}
