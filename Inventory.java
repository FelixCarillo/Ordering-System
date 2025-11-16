public class Inventory {
    public static Eyeglass[] getEyeglasses() {
        Eyeglass[] eyeglasses = {
            new Eyeglass(1, "ESY Eyestyle Eyest2505", "Stainless Steel and Acetate", 999.00, "Browline, square", "Black, Black and Gold, Crystal Black, Crystal Brown"),
            new Eyeglass(2, "ESY Young", "Stainless Steel", 2580.00,"Aviator","Black, Copper, Gold, Grey, Matt Rose Gold, and Toffee"),
            new Eyeglass(3, "ESY Woo-Wide", "Stainless Steal", 2580.00, "Rectangle", "Black, Burgundy, Chery Blossom, Crimson, Grey, Lavander, anti-glare, and UV protection"),
            new Eyeglass(4, "ESY Eyeweak Kyle", "Stainless Steel", 2580.00, "Aviator, full rim", "Antique Gun, S. Gold, S. Brown, Matt Brown"),
            new Eyeglass(5, "ESY Eyewear Sullivan", "Stainless Steal", 2580.00, "Round", "M.Black/S.Gun, M.Solid Brown/S.R.Gold, M.Brown/S.L.Brown, M.L.Grey/S.J.Gold, and M.S.Beige/S.R.Gold"),
            new Eyeglass(6, "ESY Eyewear Elvis", "TR90 and B-titanium", 2580.00, "Full rim rectangle", "Barn"),
            new Eyeglass(7, "ESY Eyewear Donovan Clip-On", "Metal", 2980.00, "Full rim square", "Pink"),
            new Eyeglass(8, "ESY Eyewear Alexandra", "Acetate", 2580.00, "Full rim square", "Crstal med grey"),
            new Eyeglass(9, "ESY Eyewear Breakthrough-Wider", "Metal", 2580.00, "Full rim rectangle", "Matt silver and copper"),
            new Eyeglass(10, "ESY Zack", "Metal", 2580.00, "Aviator/Pilot", "M.Gun/M.Silver"),
            new Eyeglass(11, "ESY Neil", "Stainless steel", 2580.00, "Full rim rectangle", "Matt Gun, S.Gun, S.Brown, and S.Gun/Purple"),
            new Eyeglass(12, "ESY Eyestyle eyest2506", "Stainless Steal and Acetate", 999.00, "Browline, square", "Black, Black and Gold, Crystal Black, Crystal Brown"),
            new Eyeglass(13, "ESY Eyestyle eyest2504", "Stainless steel and Acetate", 999.00, "Browline, square", "Black, Black and Gold, Black and Silver, Crystal Black, Crystal Brown"),
            new Eyeglass(14, "ESY Eyewear Galatia", "TR90", 2580.00, "Square", "M.Solid Blue/M.T.L Green, M.Clear and S.Black/S.T.Green"),
            new Eyeglass(15, "ESY Eyestyle eyest2503", "stainless steel and Acetate", 999.00, "Browline, sqaure", "Black, Black and Gold, Crystal Black, Crystal Brown"),
            new Eyeglass(16, "ESY Eyewear Carrie", "Stainless steel", 2580.00, "Round", "S. Olive, S.Gun/Purple"),
        };
        return eyeglasses;
    }
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

         public static Contacts[] getContacts() {
        	Contacts[] contacts = {
        			new Contacts(1, "ESY Acuvue Moist", "(Daily/30 Lenses)", 400.0),
        			new Contacts(2,"ESY Acuvue Oasys","(Once a Month/6 Lenses)", 2000.0),
        			new Contacts(3,"ESY Acuvue Oasys Astigmatism", "(Once a Month/6 Lenses)", 3000.0),
        			new Contacts(4,"ESY Air Optix", "(Once a Month/3 Lenses)", 1500.0),
        			new Contacts(5,"ESY Air Optix Astigmatism", "(Once a Month/3 Lenses)", 2000.0),
        			new Contacts(6,"ESY Dailies Total Astigmatism", "(Daily/30 Lenses)", 500.0),
        			new Contacts(7,"ESY Easyvision Elision", "(Daily/30 Lenses)", 500.0),
        			new Contacts(8,"ESY Easyvision Irisian", "(Once a Month/3 Lenses)", 1500.0),
        			new Contacts(9,"ESY Easyvision Linerial", "(Daily/30 Lenses)", 500.0),
        			new Contacts(10,"ESY Easyvision Serima", "(Daily/30 Lenses)", 500.0),
       				new Contacts(11,"ESY Easyvision Soria", "(Daily/30 Lenses)", 500.0),
   					new Contacts(12,"ESY Easyvision Vitrea", "(Daily/30 Lenses)", 500.0),
      				new Contacts(13,"ESY Lumiere", "(Once a Week/12 Lenses)", 1000.0),
       				new Contacts(14,"ESY Precision", "(Daily/30 Lenses)", 500.0),
      				new Contacts(15,"ESY Precision Astigmatism", "(Daily/30 Lenses)", 1000.0),
     				new Contacts(16,"ESY Proclear", "(Once a Month/3 Lenses)", 1000.0),
      				new Contacts(17,"ESY Proclear Toric", "(Once a Month/3 Lenses)", 1000.0)
            };
            return contacts;
    }
}
