(ns myproject.data)

(def body-structure-and-appearance
  [
   {
    :title "Frame"
    :vata "Tall or short, thin; poorly developed physique"
    :pitta "Medium; moderately developed physique"
    :kapha "Stout, stocky, short, big; well developed physique"
    }
   {
    :title "Weight"
    :vata "Low, hard to hold weight, prominent veins and bones"
    :pitta "Moderate, good muscles"
    :kapha "Heavy, tends towards obesity"
    }
   {
    :title "Complexion"
    :vata "Dull, brown, darkish"
    :pitta "Red, ruddy, flushed, glowing"
    :kapha "White, pale"
    }
   {
    :title "Skin texture and temperature"
    :vata "Thin, dry, cold, rough, cracked, prominent veins"
    :pitta "Warm, moist, pink, with moles, freckles, acne"
    :kapha "Thick, white, moist, cold, soft, smooth"
    }
   {
    :title "Hair"
    :vata "Scanty, coarse, dry, brown slightly wavy"
    :pitta "Moderate, fine, soft, early gray or bald"
    :kapha "Abundant, oily, thick, very wavy, lustrous"
    }
   {
    :title "Head"
    :vata "Small, thin, long, unsteady"
    :pitta "Moderate"
    :kapha "Large, stocky, steady"
    }
   {
    :title "Forehead"
    :vata "Small, wrinkled"
    :pitta "Moderate, with folds"
    :kapha "Large, broad"
    }
   {
    :title "Face"
    :vata "Thin, small, long, wrinkled, dusky, dull"
    :pitta "Moderate, ruddy, sharp countours"
    :kapha "Large, round, fat, white or pale, soft contours"
    }
   {
    :title "Neck"
    :vata "Thin, long"
    :pitta "Medium"
    :kapha "Large, thick"
    }
   {
    :title "Eyebrows"
    :vata "Small, thin, unsteady"
    :pitta "Moderate, fine"
    :kapha "Thick, bushy, many hairs"
    }
   {
    :title "Eyelashes"
    :vata "Small, dry, firm"
    :pitta "Small, thin, fine"
    :kapha "Large, thick, oily, firm"
    }
   {
    :title "Eyes"
    :vata "Small, dry, thin, brown, dull, unsteady"
    :pitta "Medium, thin, red (inflamed easily), green, piercing"
    :kapha "Wide, prominent, thick, oily, white, attractive"
    }
   {
    :title "Nose"
    :vata "Thin, small, long, dry, crooked"
    :pitta "Medium"
    :kapha "Thick, big, firm, oily"
    }
   {
    :title "Lips"
    :vata "Thin, small, darkish, dry, unsteady"
    :pitta "Medium, soft, red"
    :kapha "Thick, large, oily, smooth, firm"
    }
   {
    :title "Teeth & gums"
    :vata "Thin, dry, small, rough, crooked, receding gums"
    :pitta "Medium, soft, pink, gums bleed easily"
    :kapha "Large, thick, soft, pink, oily"
    }
   {
    :title "Shoulders"
    :vata "Thin, small, flat, hunched"
    :pitta "Medium"
    :kapha "Broad, thick, firm, oily"
    }
   {
    :title "Chest"
    :vata "Thin, small, narrow, poorly developed"
    :pitta "Medium"
    :kapha "Broad, large, well or overly developed"
    }
   {
    :title "Arms"
    :vata "Thin, overly small or long, poorly developed"
    :pitta "Medium"
    :kapha "Large, thick, round, well developed"
    }
   {
    :title "Hands"
    :vata "Small, thin, dry, cold, rough, fissured, unsteady"
    :pitta "Medium, warm, pink"
    :kapha "Large, thick, oily, cool, firm"
    }
   {
    :title "Thighs"
    :vata "Thin, narrow"
    :pitta "Medium"
    :kapha "Well-developed, round, fat"
    }
   {
    :title "Legs"
    :vata "Thin, excessively long or short, prominent knees"
    :pitta "Medium"
    :kapha "Large, stocky"
    }
   {
    :title "Calves"
    :vata "Small, hard, tight"
    :pitta "Loose, soft"
    :kapha "Shapely, firm"
    }
   {
    :title "Feet"
    :vata "Small, thin, long, dry, rough, fissured, unsteady"
    :pitta "Medium, soft, pink"
    :kapha "Large, thick, hard, firm"
    }
   {
    :title "Joints"
    :vata "Small, thin, dry, unsteady, cracking"
    :pitta "Medium, soft, loose"
    :kapha "Large, thick, well built"
    }
   {
    :title "Nails"
    :vata "Small, thin, dry, rough, fissured, cracked, darkish"
    :pitta "Medium, soft, pink"
    :kapha "Large, thick, smooth, white, firm, oily"
    }
   ]
  )

(def waste-materials-and-metabolism
  [
   {
    :title "Urine"
    :vata "Scanty, difficult, colorless"
    :pitta "Profuse, yellow, red, burning"
    :kapha "Moderate, whitish, milky"
    }
   {
    :title "Feces"
    :vata "Scanty, dry, hard, difficult or painful, gas, tends towards constipation"
    :pitta "Abundant, loose, yellowish, tends to diarrhea, with burning sensation"
    :kapha "Moderate, solid, sometimes pale in color, mucus in stool"
    }
   {
    :title "Sweat/body odor"
    :vata "Scanty, no smell"
    :pitta "Profuse, hot, strong smell"
    :kapha "Moderate, cold, pleasant smell"
    }
   {
    :title "Appetite"
    :vata "Variable, erratic"
    :pitta "Strong, sharp"
    :kapha "Constant, low"
    }
   {
    :title "Taste preferences"
    :vata "Prefers sweet, sour, or salty food, cooked with oil and spiced"
    :pitta "Prefers sweet, bitter or astringent food, raw, lightly cooked without spices or extra salt"
    :kapha "Prefers pungent, bitter or astringent food, cooked with spices but not oil"
    }
   {
    :title "Circulation"
    :vata "Poor, variable, erratic"
    :pitta "Good, warm"
    :kapha "Slow, steady"
    }
   ]
  )

(def general-characteristics
  [
   {
    :title "Activity"
    :vata "Quick, fast, unsteady, erratic, hyperactive"
    :pitta "Medium, motivated, purposeful, goal seeking"
    :kapha "Slow, steady, stately"
    }
   {
    :title "Strength/endurance"
    :vata "Low, poor endurance, starts and stops quickly"
    :pitta "Medium, intolerant of heat"
    :kapha "Strong, good endurance, but slow in starting"
    }
   {
    :title "Sexual nature"
    :vata "Variable, erratic, deviant, strong desire but low energy, few children"
    :pitta "Moderate, passionate, quarrelsome, dominating"
    :kapha "Low but constant sexual desire, good sexual energy, devoted, many children"
    }
   {
    :title "Sensitivity"
    :vata "Fear of cold, wind, sensitive to dryness"
    :pitta "Fear of heat, dislike of sun, fire"
    :kapha "Fear of cold, damp, likes wind and sun"
    }
   {
    :title "Resistance to disease"
    :vata "Poor, variable, weak immune system"
    :pitta "Medium, prone to infection"
    :kapha "Good, prone to congestive disorders"
    }
   {
    :title "Disease tendency"
    :vata "Nervous system diseases, pain, arthritis, mental disorders"
    :pitta "Fevers, infections, inflammatory diseases"
    :kapha "Respiratory system diseases, mucus, edema"
    }
   {
    :title "Reaction to medications"
    :vata "Quick, low dosage needed, unexpected side effects or nervous reactions"
    :pitta "Medium, average dosage"
    :kapha "Slow, high dosage required, effects slow to manifest"
    }
   {
    :title "Pulse"
    :vata "Thready, rapid, superficial, irregular, weak; like a snake"
    :pitta "Wiry, bounding, moderate; like a frog"
    :kapha "Deep, slow, steady, rolling, slippery; like a swan"
    }
   ]
  )

(def mental-factors-and-expressions
  [
   {
    :title "Voice"
    :vata "Low, weak, hoarse"
    :pitta "High pitch, sharp"
    :kapha "Pleasant, deep, good tone"
    }
   {
    :title "Speech"
    :vata "Quick, inconsistent, erratic, talkative"
    :pitta "Moderate, argumentative, convincing"
    :kapha "Slow, definite, not talkative"
    }
   {
    :title "Mental nature"
    :vata "Quick, adaptable, indecisive"
    :pitta "Intelligent, penetrating, critical"
    :kapha "Slow, steady, dull"
    }
   {
    :title "Memory"
    :vata "Poor, notices things easily but easily forgets"
    :pitta "Sharp, clear"
    :kapha "Slow to take notice, but will not forget"
    }
   {
    :title "Finances"
    :vata "Earns and spends quickly, erratically"
    :pitta "Spends on specific goals, causes or projects"
    :kapha "Holds on to what one earns, particularly property"
    }
   {
    :title "Emotional tendencies"
    :vata "Fearful, anxious, nervous"
    :pitta "Angry, irritable, contentious"
    :kapha "Calm, content, attached, sentimental"
    }
   {
    :title "Neurotic tendencies"
    :vata "Hysteria, trembling, anxiety attacks"
    :pitta "Extreme temper, rage, tantrums"
    :kapha "Depression, unresponsiveness, sorrow"
    }
   {
    :title "Faith"
    :vata "Erratic, changeable, rebel"
    :pitta "Determined, fanatic, leader"
    :kapha "Constant, loyal, conservative"
    }
   {
    :title "Sleep"
    :vata "Light, tends towards insomnia"
    :pitta "Moderate, may wake up but will fall asleep again"
    :kapha "Heavy, difficulty in waking up"
    }
   {
    :title "Dreams"
    :vata "Flying, moving, restless, nightmares"
    :pitta "Colorful, passionate, conflict"
    :kapha "Romantic, sentimental, watery, few dreams"
    }
   {
    :title "Habits"
    :vata "Likes speed, traveling, parks, plays, jokes, stories, trivia, artistic activities, dancing"
    :pitta "Likes competitive sports, debates, politics, hunting, research"
    :kapha "Likes water, sailing, flowers, cosmetics, business ventures, cooking"
    }
   ]
  )

(def raw-quiz
  [
   {
    :type "Body structure and appearance"
    :questions body-structure-and-appearance
    }
   {
    :type "Waste materials/metabolism"
    :questions waste-materials-and-metabolism
    }
   {
    :type "General characteristics"
    :questions general-characteristics
    }
   {
    :type "Mental factors and expressions"
    :questions mental-factors-and-expressions
    }
   ]
  )

(defn flatten-quiz-part [part]
  (->>
    part
    :questions
    (map #(assoc % :type (:type part)))
    )
  )

(defn flatten-quiz [raw-quiz]
  (->>
    raw-quiz
    (map flatten-quiz-part)
    (apply concat)
    )
  )

(defn assign-ix-as-id [ix question]
  (assoc question :id ix)
  )

(def quiz
  (->>
    raw-quiz
    flatten-quiz
    (map-indexed assign-ix-as-id)
    )
  )

(def default-answers
  (->>
    quiz
    (map (fn [question] {(:id question) {:kapha 0.0 :pitta 0.0 :vata 0.0}}))
    (apply merge)
    )
  )
