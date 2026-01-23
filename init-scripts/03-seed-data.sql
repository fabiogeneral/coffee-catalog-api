-- Seed Flavor Notes
INSERT INTO flavor_notes (name, category)
VALUES
-- Fruity
('Blueberry', 'Fruity'),
('Strawberry', 'Fruity'),
('Cherry', 'Fruity'),
('Lemon', 'Citrus'),
('Orange', 'Citrus'),
('Apple', 'Fruity'),
-- Chocolatey/Nutty
('Dark Chocolate', 'Chocolatey'),
('Milk Chocolate', 'Chocolatey'),
('Caramel', 'Sweet'),
('Almond', 'Nutty'),
('Hazelnut', 'Nutty'),
-- Floral
('Jasmine', 'Floral'),
('Rose', 'Floral'),
('Lavender', 'Floral'),
-- Spicy/Earthy
('Cinnamon', 'Spicy'),
('Earthy', 'Earthy'),
('Tobacco', 'Earthy');

-- Seed Test User
INSERT INTO users (email, password, first_name, last_name, role)
VALUES ('admin@coffee.com', '$2a$10$dummyhash', 'Admin', 'User', 'ADMIN'),
       ('roaster@coffee.com', '$2a$10$dummyhash', 'Coffee', 'Roaster', 'ROASTER');

-- Seed Test Roaster
INSERT INTO roasters (user_id, company_name, description, location, is_verified)
VALUES
    (2, 'Artisan Coffee Roasters', 'Premium small-batch coffee roasting', 'Portland, OR', true);

-- Seed Test Coffee
INSERT INTO coffees (
    roaster_id,
    name,
    description,
    origin_country,
    origin_region,
    altitude_meters,
    varietal,
    processing_method,
    roast_level,
    roast_date,
    price,
    weight_grams,
    acidity_level,
    sweetness_level,
    bitterness_level,
    image_url,
    is_active
) VALUES

-- 1. Ethiopian Yirgacheffe (Light Roast)
(
    '1',
    'Ethiopian Yirgacheffe Natural',
    'Floral and fruity with complex berry notes. A bright, tea-like body with jasmine and blueberry flavors.',
    'Ethiopia',
    'Yirgacheffe',
    1700,
    'Heirloom',
    'Natural',
    'Light',
    CURRENT_DATE - INTERVAL '5 days',
    18.99,
    340,
    9,
    8,
    2,
    'https://images.unsplash.com/photo-1447933601403-0c6688de566e',
    true
),

-- 2. Colombian Supremo (Medium Roast)
(
    '1',
    'Colombian Supremo',
    'Classic Colombian profile with balanced sweetness and nutty caramel notes.',
    'Colombia',
    'Huila',
    1400,
    'Caturra',
    'Washed',
    'Medium',
    CURRENT_DATE - INTERVAL '3 days',
    16.99,
    340,
    6,
    7,
    4,
    'https://images.unsplash.com/photo-1514432324607-a09d9b4aefdd',
    true
),

-- 3. Sumatra Mandheling (Dark Roast)
(
    '1',
    'Sumatra Mandheling',
    'Full-bodied Indonesian coffee with earthy, herbal notes and low acidity.',
    'Indonesia',
    'Sumatra',
    1000,
    'Typica',
    'Wet-Hulled (Giling Basah)',
    'Dark',
    CURRENT_DATE - INTERVAL '7 days',
    17.99,
    340,
    2,
    4,
    7,
    'https://images.unsplash.com/photo-1559056199-641a0ac8b55e',
    true
),

-- 4. Kenya AA (Medium-Light Roast)
(
    '1',
    'Kenya AA Kirinyaga',
    'Bright, wine-like acidity with black currant and grapefruit notes.',
    'Kenya',
    'Kirinyaga',
    1500,
    'SL28, SL34',
    'Washed',
    'Medium-Light',
    CURRENT_DATE - INTERVAL '2 days',
    19.99,
    340,
    9,
    7,
    3,
    'https://images.unsplash.com/photo-1495474472287-4d71bcdd2085',
    true
),

-- 5. Brazilian Santos (Medium Roast)
(
    '1',
    'Brazilian Santos',
    'Low acidity, nutty and chocolatey. Perfect for espresso blends.',
    'Brazil',
    'Minas Gerais',
    900,
    'Bourbon',
    'Natural',
    'Medium',
    CURRENT_DATE - INTERVAL '4 days',
    15.99,
    340,
    4,
    6,
    5,
    'https://images.unsplash.com/photo-1509042239860-f550ce710b93',
    true
),

-- 6. Guatemala Antigua (Medium Roast)
(
    '1',
    'Guatemala Antigua Volcanic',
    'Grown in volcanic soil, offering chocolate and spice notes with smoky undertones.',
    'Guatemala',
    'Antigua',
    1300,
    'Bourbon, Caturra',
    'Washed',
    'Medium',
    CURRENT_DATE - INTERVAL '6 days',
    17.49,
    340,
    6,
    6,
    4,
    'https://images.unsplash.com/photo-1442512595331-e89e73853f31',
    true
),

-- 7. Costa Rica Tarrazu (Light-Medium Roast)
(
    '1',
    'Costa Rica Tarrazu',
    'Crisp and clean with citrus brightness and honey sweetness.',
    'Costa Rica',
    'Tarrazu',
    1200,
    'Caturra, Catuai',
    'Honey',
    'Light-Medium',
    CURRENT_DATE - INTERVAL '1 days',
    18.49,
    340,
    7,
    8,
    3,
    'https://images.unsplash.com/photo-1497935586351-b67a49e012bf',
    true
),

-- 8. Rwanda Bourbon (Light Roast)
(
    '1',
    'Rwanda Bourbon',
    'Floral and fruity African coffee with red fruit notes and tea-like body.',
    'Rwanda',
    'Western Province',
    1700,
    'Red Bourbon',
    'Fully Washed',
    'Light',
    CURRENT_DATE - INTERVAL '8 days',
    19.49,
    340,
    8,
    8,
    2,
    'https://images.unsplash.com/photo-1511920170033-f8396924c348',
    true
),

-- 9. Panama Geisha (Light Roast - Premium)
(
    '1',
    'Panama Geisha Volcan Baru',
    'Award-winning variety with jasmine, tropical fruit, and complex floral notes.',
    'Panama',
    'Boquete',
    1400,
    'Geisha',
    'Washed',
    'Light',
    CURRENT_DATE - INTERVAL '2 days',
    34.99,
    250,
    10,
    9,
    1,
    'https://images.unsplash.com/photo-1453614512568-c4024d13c247',
    true
),

-- 10. Mexico Chiapas (Medium Roast)
(
    '1',
    'Mexico Chiapas Organic',
    'Smooth and balanced with chocolate and nut notes. Certified organic and fair trade.',
    'Mexico',
    'Chiapas',
    1000,
    'Typica, Bourbon',
    'Washed',
    'Medium',
    CURRENT_DATE - INTERVAL '5 days',
    16.49,
    340,
    5,
    6,
    4,
    'https://images.unsplash.com/photo-1461023058943-07fcbe16d735',
    true
),

-- 11. Peru Cajamarca (Medium-Light Roast)
(
    '1',
    'Peru Cajamarca Fair Trade',
    'Bright acidity with citrus and stone fruit notes. Certified fair trade.',
    'Peru',
    'Cajamarca',
    1100,
    'Caturra, Typica',
    'Washed',
    'Medium-Light',
    CURRENT_DATE - INTERVAL '3 days',
    15.99,
    340,
    7,
    7,
    3,
    'https://images.unsplash.com/photo-1506619216599-9d16d0903dfd',
    true
),

-- 12. Honduras Marcala (Medium Roast)
(
    '1',
    'Honduras Marcala',
    'Sweet and smooth Central American coffee with caramel and cocoa notes.',
    'Honduras',
    'Marcala',
    1300,
    'Catuai, Lempira',
    'Washed',
    'Medium',
    CURRENT_DATE - INTERVAL '4 days',
    15.49,
    340,
    6,
    7,
    4,
    'https://images.unsplash.com/photo-1477763858572-cda7deaa9bc5',
    true
),

-- 13. Nicaragua Jinotega (Medium Roast)
(
    '1',
    'Nicaragua Jinotega',
    'Full-bodied with chocolate and nutty flavors. Great for espresso.',
    'Nicaragua',
    'Jinotega',
    1000,
    'Caturra, Bourbon',
    'Washed',
    'Medium',
    CURRENT_DATE - INTERVAL '7 days',
    16.99,
    340,
    5,
    6,
    5,
    'https://images.unsplash.com/photo-1447933078955-509458a1955c',
    true
),

-- 14. El Salvador Pacamara (Light-Medium Roast)
(
    '1',
    'El Salvador Pacamara',
    'Unique large-bean variety with tropical fruit and floral complexity.',
    'El Salvador',
    'Santa Ana',
    1200,
    'Pacamara',
    'Washed',
    'Light-Medium',
    CURRENT_DATE - INTERVAL '2 days',
    20.99,
    340,
    8,
    8,
    2,
    'https://images.unsplash.com/photo-1495474472287-4d71bcdd2085',
    true
),

-- 15. Yemen Mocha (Medium-Dark Roast)
(
    '1',
    'Yemen Mocha Matari',
    'Wild and complex with wine-like fruit and spice. Traditional sun-dried.',
    'Yemen',
    'Bani Matari',
    1800,
    'Typica, Bourbon',
    'Natural',
    'Medium-Dark',
    CURRENT_DATE - INTERVAL '10 days',
    24.99,
    250,
    5,
    6,
    6,
    'https://images.unsplash.com/photo-1514066558159-fc8c737ef259',
    true
),

-- 16. Tanzania Peaberry (Light-Medium Roast)
(
    '1',
    'Tanzania Peaberry Kilimanjaro',
    'Single-bean peaberry with bright acidity and black currant notes.',
    'Tanzania',
    'Kilimanjaro',
    1400,
    'Bourbon, Kent',
    'Washed',
    'Light-Medium',
    CURRENT_DATE - INTERVAL '4 days',
    18.99,
    340,
    8,
    7,
    3,
    'https://images.unsplash.com/photo-1509042239860-f550ce710b93',
    true
),

-- 17. India Monsooned Malabar (Dark Roast)
(
    '1',
    'India Monsooned Malabar',
    'Unique processing creates low acidity and earthy, spicy character.',
    'India',
    'Karnataka',
    1000,
    'Kent, S795',
    'Monsooned',
    'Dark',
    CURRENT_DATE - INTERVAL '9 days',
    17.99,
    340,
    1,
    3,
    7,
    'https://images.unsplash.com/photo-1442512595331-e89e73853f31',
    true
),

-- 18. Jamaica Blue Mountain (Light Roast - Premium)
(
    '1',
    'Jamaica Blue Mountain',
    'Legendary mild coffee with exceptional balance and subtle sweetness.',
    'Jamaica',
    'Blue Mountains',
    900,
    'Typica',
    'Washed',
    'Light',
    CURRENT_DATE - INTERVAL '1 days',
    39.99,
    250,
    6,
    8,
    2,
    'https://images.unsplash.com/photo-1497935586351-b67a49e012bf',
    true
),

-- 19. Hawaii Kona (Medium Roast)
(
    '1',
    'Hawaii Kona Extra Fancy',
    'Premium Hawaiian coffee with smooth, rich flavor and low acidity.',
    'United States',
    'Kona, Hawaii',
    500,
    'Typica',
    'Washed',
    'Medium',
    CURRENT_DATE - INTERVAL '3 days',
    29.99,
    250,
    5,
    8,
    3,
    'https://images.unsplash.com/photo-1511920170033-f8396924c348',
    true
),

-- 20. Burundi (Light Roast)
(
    '1',
    'Burundi Kayanza',
    'Bright African coffee with cherry, citrus, and floral notes.',
    'Burundi',
    'Kayanza',
    1700,
    'Bourbon',
    'Washed',
    'Light',
    CURRENT_DATE - INTERVAL '5 days',
    18.49,
    340,
    8,
    8,
    2,
    'https://images.unsplash.com/photo-1453614512568-c4024d13c247',
    true
);
