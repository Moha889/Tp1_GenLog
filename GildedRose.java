package com.gildedrose;

/*class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      if (!items[i].name.equals("Aged Brie")
          && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        if (items[i].quality > 0) {
          if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].quality = items[i].quality - 1;
          }
        }
      } else {
        if (items[i].quality < 50) {
          items[i].quality = items[i].quality + 1;

          if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items[i].sellIn < 11) {
              if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
              }
            }

            if (items[i].sellIn < 6) {
              if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
              }
            }
          }
        }
      }

      if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
        items[i].sellIn = items[i].sellIn - 1;
      }

      if (items[i].sellIn < 0) {
        if (!items[i].name.equals("Aged Brie")) {
          if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items[i].quality > 0) {
              if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].quality = items[i].quality - 1;
              }
            }
          } else {
            items[i].quality = items[i].quality - items[i].quality;
          }
        } else {
          if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
          }
        }
      }
    }
  }
}
*/
class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
      this.items = items;
  }

  public void updateQuality() {
      for (Item item : items) {
          updateItemQuality(item);
      }
  }

  private void updateItemQuality(Item item) {
      if (!isSpecialItem(item)) {
          decreaseQuality(item);
      } else {
          increaseQuality(item);

          if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
              if (item.sellIn < 11) {
                  increaseQuality(item);
              }

              if (item.sellIn < 6) {
                  increaseQuality(item);
              }
          }
      }

      if (!isLegendaryItem(item)) {
          item.sellIn -= 1;

          if (item.sellIn < 0) {
              if (!isSpecialItem(item)) {
                  decreaseQuality(item);
              } else {
                  item.quality = 0;
              }
          }
      }
  }

  private boolean isSpecialItem(Item item) {
      return item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  private boolean isLegendaryItem(Item item) {
      return item.name.equals("Sulfuras, Hand of Ragnaros");
  }

  private void increaseQuality(Item item) {
      if (item.quality < 50) {
          item.quality += 1;
      }
  }

  private void decreaseQuality(Item item) {
      if (item.quality > 0) {
          item.quality -= 1;
      }
  }
}



